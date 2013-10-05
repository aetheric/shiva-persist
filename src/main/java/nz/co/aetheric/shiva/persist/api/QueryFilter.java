package nz.co.aetheric.shiva.persist.api;

/**
 * This interface defines an object that embodies a particular expression filter. The only state a filter should store
 * is that of its filtering parameters, but ideally, each filter will provide a custom application method for manually
 * overriding one or more of them.
 * @param <ResultType> The result type to filter for. May be generic.
 */
public interface QueryFilter<ResultType> {

	/**
	 * Applies the filter to the query, thereby limiting its results.
	 * @param query The query to apply the filter to.
	 */
	public void apply(Query<ResultType> query);

}