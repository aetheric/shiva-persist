public interface Query<ResultType> {

	public ResultType getResult();

	public ResultType getFirstResult();

	public List<ResultType> getResultList();

	public PaginatedResultList<ResultType> getPaginatedResultList(int max, int start);

}