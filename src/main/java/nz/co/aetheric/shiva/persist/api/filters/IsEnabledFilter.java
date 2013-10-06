package nz.co.aetheric.shiva.persist.api.filters;

import nz.co.aetheric.shiva.persist.api.Query;
import nz.co.aetheric.shiva.persist.api.QueryFilter;
import nz.co.aetheric.shiva.persist.api.types.Enableable;

/**
 * This abstract implementation filters based on whether the entity is enabled, disabled, or the value is null.
 * Concrete implementations of this class will determine how that is checked and applied.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public abstract class IsEnabledFilter<QueryType extends Query<? extends Enableable, ?>>
		implements QueryFilter<QueryType> {

	protected final Boolean enabled;

	/**
	 * Instantiate the filter with the provided default filter value.
	 * @param enabled Whether all of the desired results are enabled, disabled, or undetermined.
	 */
	protected IsEnabledFilter(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Provides access to the default 'enabled' state of the filter.
	 * @return Returns what 'enabled' state the filter is in.
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * Will filter the provided query to ensure that all results match the default enabled state.
	 * @param query The query to apply the filter to.
	 */
	@Override
	public abstract void apply(QueryType query);

	/**
	 * This overloading of the {@link #apply(Query)} method allows the enabled state to be specified.
	 * @param query The query to apply the filter to.
	 * @param enabled Whether the
	 */
	public abstract void apply(QueryType query, Boolean enabled);

}
