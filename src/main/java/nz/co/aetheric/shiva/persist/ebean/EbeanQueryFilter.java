package nz.co.aetheric.shiva.persist.ebean;

import com.avaje.ebean.ExpressionFactory;
import nz.co.aetheric.shiva.persist.api.QueryFilter;

/**
 * This abstract definition of a QueryFilter provides its implementations with an {@link ExpressionFactory} to use when
 * creating the expressions to apply to provided queries.
 * <p>Author: <a href="http://gplus.to/tzrlk">Peter Cummuskey</a></p>
 */
public abstract class EbeanQueryFilter<ResultType>
		implements QueryFilter<EbeanQuery<ResultType>> {

	protected final ExpressionFactory expressions;

	protected EbeanQueryFilter(ExpressionFactory expressions) {
		this.expressions = expressions;
	}

	@Override
	public abstract void apply(EbeanQuery<ResultType> query);

}
