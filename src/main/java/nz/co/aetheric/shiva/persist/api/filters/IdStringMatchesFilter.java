package nz.co.aetheric.shiva.persist.api.filters;

import nz.co.aetheric.shiva.persist.api.Query;
import nz.co.aetheric.shiva.persist.api.QueryFilter;
import nz.co.aetheric.shiva.persist.api.types.Identifiable;

/**
 * Filters a query on whether the provided string matches the result ids.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public interface IdStringMatchesFilter<QueryType extends Query<? extends Identifiable<String>, ?>>
		extends QueryFilter<QueryType> {

	public String getMatch();

	@Override
	public void apply(QueryType query);

	public void apply(QueryType query, String match);

}
