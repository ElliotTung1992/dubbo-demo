package com.github.dge1992.dubboprovider.filter;

import org.apache.dubbo.rpc.*;
import org.slf4j.MDC;

/**
 * 生产者dubbo过滤器
 */
public class ProviderFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        String traceId = RpcContext.getContext().getAttachment("traceId");

        MDC.put("traceId", traceId);

        Result result = invoker.invoke(invocation);

        return result;
    }
}
