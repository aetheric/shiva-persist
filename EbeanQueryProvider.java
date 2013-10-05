public abstract class EbeanQueryProvider<QueryType extends EbeanQuery, ResultType>
		implements QueryProvider<QueryType, ResultType> {
	
	protected EbeanServer ebean;

	protected ExpressionList<ResultType> getExpression(Class<ResultType> clazz) {
		return ebean.find(clazz).where();
	}

}