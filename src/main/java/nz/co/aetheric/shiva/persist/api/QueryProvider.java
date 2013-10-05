public interface QueryProvider<QueryType extends Query<ResultType>, ResultType> {

	public QueryType getQuery();

}