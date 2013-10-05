package nz.co.aetheric.shiva.persist.api;

public interface QueryProvider<QueryType extends Query<ResultType>, ResultType> {

	public QueryType getQuery();

}