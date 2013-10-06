package nz.co.aetheric.shiva.persist.api.filters;

import nz.co.aetheric.shiva.persist.api.Query;
import nz.co.aetheric.shiva.persist.api.QueryFilter;
import nz.co.aetheric.shiva.persist.api.types.Enableable;

/**
 * This abstract implementation filters based on whether the entity is enabled, disabled, or the value is null.
 * Concrete implementations of this class will determine how that is checked and applied.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public interface IsEnabledFilter<QueryType extends Query<? extends Enableable, ?>>
		extends QueryFilter<QueryType> {

	/**
	 * Provides access to the default 'enabled' state of the filter.
	 * @return Returns what 'enabled' state the filter is in.
	 */
	public Boolean getEnabled();

	/**
	 * Will filter the provided query to ensure that all results match the default enabled state.
	 * @param query The query to apply the filter to.
	 */
	@Override
	public void apply(QueryType query);

	/**
	 * This overloading of the {@link #apply(Query)} method allows the enabled state to be specified.
	 * @param query The query to apply the filter to.
	 * @param enabled Whether the entities are enabled, disabled or undetermined.
	 */
	public void apply(QueryType query, Boolean enabled);

}
