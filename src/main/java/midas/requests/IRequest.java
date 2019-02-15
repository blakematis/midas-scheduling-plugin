package midas.requests;

/**
 * @Author Blake Matis
 * @version 1.0
 * @since 1.0
 * @see <a href="https://mid.as/api/api-command-reference">API Command Reference</a>
 */
public interface IRequest {

    /**
     *
     * @return The command reference with all of its required and/or optional parameters.
     */
    public abstract String requestUrl();

}
