package nz.co.aetheric.shiva.persist.api;

/**
 * This interface defines an object that embodies a particular expression filter. The only state a filter should store
 * is that of its filtering parameters, but ideally, each filter will provide a custom application method for manually
 * overriding one or more of them.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 * @param <QueryType> The type of Query to filter on.
 */
public interface QueryFilter<QueryType extends Query> {

	/**
	 * Applies the filter to the query, thereby limiting its results.
	 * @param query The query to apply the filter to.
	 */
	public void apply(QueryType query);

}