public abstract class EbeanQuery<ResultType>
		extends Query<ResultType> {

	protected ExpressionList<ResultType> expressionList;

	public ResultType getResult() {
		return expressionList.findUnique();
	}

	public ResultType getFirstResult() {
		return expressionList
				.setMaxRows(1)
				.findUnique();
	}

	public List<ResultType> getResultList() {
		return expressionList.findList();
	}

	public PaginatedResultList<ResultType> getPaginatedResultList(int max, int start) {

		// Start working on the row count of the un-paginated query expression.
		FutureRowCount<ResultType> rowCount = expressionList.findFutureRowCount();

		// Paginate the query expression and retrieve the results.
		List<ResultType> results = expressionList
				.setMaxRows(max)
				.setFirstRow(start)
				.findList();

		// Wrap both bits of information in a useful package.
		return new PaginatedResultList(results, total.get());

	}

}