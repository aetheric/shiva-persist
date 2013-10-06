package nz.co.aetheric.shiva.persist.ebean;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.FutureRowCount;
import nz.co.aetheric.shiva.persist.api.PaginatedResultList;
import nz.co.aetheric.shiva.persist.api.QueryManager;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class EbeanQueryManager<ResultType>
		implements QueryManager<EbeanQuery<ResultType>, ResultType> {
	
	private final EbeanServer ebean;
	private final Class<ResultType> resultType;

	public EbeanQueryManager(EbeanServer ebean, Class<ResultType> resultType) {
		this.ebean = ebean;
		this.resultType = resultType;
	}

	@Override
	public EbeanQuery<ResultType> getQuery() {
		ExpressionList<ResultType> context = this.getExpressionList();
		return new EbeanQuery<>(resultType, context);
	}

	protected ExpressionList<ResultType> getExpressionList() {
		return ebean.find(resultType).where();
	}

	@Override
	public ResultType getResult(EbeanQuery<ResultType> query) {
		return query.getContext()
				.findUnique();
	}

	@Override
	public ResultType getFirstResult(EbeanQuery<ResultType> query) {
		return query.getContext()
				.setMaxRows(1)
				.findUnique();
	}

	@Override
	public List<ResultType> getResultList(EbeanQuery<ResultType> query) {
		return query.getContext()
				.findList();
	}

	public PaginatedResultList<ResultType> getPaginatedResultList(EbeanQuery<ResultType> query, int max, int start) {
		ExpressionList<ResultType> expressionList = query.getContext();

		// Start working on the row count of the un-paginated query expression.
		FutureRowCount<ResultType> rowCount = expressionList.findFutureRowCount();

		// Paginate the query expression and retrieve the results.
		List<ResultType> results = expressionList
				.setMaxRows(max)
				.setFirstRow(start)
				.findList();

		int total = this.getTotalCount(rowCount, expressionList);

		// Wrap both bits of information in a useful package.
		return new PaginatedResultList<>(results, total);

	}

	protected int getTotalCount(FutureRowCount<ResultType> futureRowCount, ExpressionList<ResultType> expressionList) {
		try {
			return futureRowCount.get();
		} catch (InterruptedException | ExecutionException e) {
			//TODO: Add warn-level logging right here.
			return expressionList
					.setMaxRows(0)
					.setFirstRow(0)
					.findRowCount();
		}
	}

}