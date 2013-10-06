package nz.co.aetheric.shiva.persist.ebean.filters;

import com.avaje.ebean.ExpressionFactory;
import com.avaje.ebean.Expression;
import nz.co.aetheric.shiva.persist.ebean.EbeanQuery;
import nz.co.aetheric.shiva.persist.ebean.EbeanQueryFilter;

/**
 * Allows for the application of arbitrary ebean expressions to a query.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public class ImprovExpressionFilter<ResultType>
		extends EbeanQueryFilter<ResultType> {

	private final Expression expression;

	public ImprovExpressionFilter(ExpressionFactory expressions, Expression expression) {
		super(expressions);
		this.expression = expression;
	}

	@Override
	public void apply(EbeanQuery<ResultType> query) {
		query.getContext().add(expression);
	}

	public void apply(EbeanQuery<ResultType> query, Expression expression) {
		query.getContext().add(expression);
	}

}
