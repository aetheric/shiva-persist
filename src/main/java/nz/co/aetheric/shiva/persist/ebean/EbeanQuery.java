package nz.co.aetheric.shiva.persist.ebean;

import com.avaje.ebean.ExpressionList;
import nz.co.aetheric.shiva.persist.api.Query;

public class EbeanQuery<ResultType>
		extends Query<ResultType, ExpressionList<ResultType>> {

	protected EbeanQuery(Class<ResultType> resultType, ExpressionList<ResultType> context) {
		super(resultType, context);
	}

}