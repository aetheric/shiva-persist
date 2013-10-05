package nz.co.aetheric.shiva.persist.api;

import java.util.List;

public interface Query<ResultType> {

	public ResultType getResult();

	public ResultType getFirstResult();

	public List<ResultType> getResultList();

	public PaginatedResultList<ResultType> getPaginatedResultList(int max, int start);

}