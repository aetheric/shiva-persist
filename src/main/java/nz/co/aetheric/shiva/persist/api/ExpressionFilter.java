/**
 * Not so sure on this one. While it would be nice to have a standardised way of defining filters, Java doesn't deal
 * with Maps nearly as well as Groovy, making it a bad choice for easily passing arguments. The alternate way around
 * it would be to instantiate a filter with the specified arguments, and then blindly apply it to the expression.
 * Since each filter would only hold state for its arguments, you could re-use them.
 */
public interface ExpressionFilter<ExpressionType> {

	public ExpressionType filter(ExpressionType expression);

	public ExpressionType filter(ExpressionType expression, Map<String, Object> params);

}