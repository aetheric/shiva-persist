package nz.co.aetheric.shiva.persist.ebean.filters;

import com.avaje.ebean.Expression;
import com.avaje.ebean.ExpressionFactory;
import nz.co.aetheric.shiva.persist.api.filters.IsEnabledFilter;
import nz.co.aetheric.shiva.persist.api.types.Enableable;
import nz.co.aetheric.shiva.persist.ebean.EbeanQuery;
import nz.co.aetheric.shiva.persist.ebean.EbeanQueryFilter;

/**
 * This is the ebean implementation of a generic filter to make sure all results of a query are either enabled,
 * disabled, or undetermined as desired.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public class IsEnabledEbeanFilter<ResultType extends Enableable>
		extends EbeanQueryFilter<ResultType>
		implements IsEnabledFilter<EbeanQuery<ResultType>> {

	protected final Boolean enabled;

	/**
	 * Instantiate the filter with the provided default filter value.
	 * @param enabled Whether all of the desired results are enabled, disabled, or undetermined.
	 */
	protected IsEnabledEbeanFilter(ExpressionFactory expressions, Boolean enabled) {
		super(expressions);
		this.enabled = enabled;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	@Override
	public void apply(EbeanQuery<ResultType> query) {
		apply(query, enabled);
	}

	@Override
	public void apply(EbeanQuery<ResultType> query, Boolean enabled) {
		Expression expression = createExpression(enabled);
		query.getContext().add(expression);
	}

	protected Expression createExpression(Boolean enabled) {
		if (enabled == null) {
			return expressions.isNull(Enableable.FIELD_ENABLED);
		} else {
			return expressions.eq(Enableable.FIELD_ENABLED, enabled);
		}
	}

}
