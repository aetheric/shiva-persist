package nz.co.aetheric.shiva.persist.api;

/**
 * A simple interface describing any object that can maintain context for a particular query operation.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 * @param <ResultType> The type of result that the query would return.
 * @param <ContextType> The type of object that stores the query context.
 */
public abstract class Query<ResultType, ContextType> {

	private final Class<ResultType> resultType;
	private final ContextType context;

	/**
	 * This constructor ensures that all queries have access to the type of their result, and their context. Especially
	 * useful for building up queries.
	 * @param resultType The type of result that the query would return.
	 * @param context The object that stores the query context.
	 */
	protected Query(Class<ResultType> resultType, ContextType context) {
		this.resultType = resultType;
		this.context = context;
	}

	/**
	 * Provides access to the class of the result type.
	 * @return The class of the result type.
	 */
	public Class<ResultType> getResultType() {
		return this.resultType;
	}

	/**
	 * Provides access to the context object for this query.
	 * @return The context object for this query.
	 */
	public ContextType getContext() {
		return this.context;
	}

}