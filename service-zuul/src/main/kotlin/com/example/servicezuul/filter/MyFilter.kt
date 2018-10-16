package com.example.servicezuul.filter

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import org.slf4j.LoggerFactory
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants
import org.springframework.stereotype.Component


@Component
class MyFilter : ZuulFilter() {

    private val logger = LoggerFactory.getLogger(MyFilter::class.java)

    override fun run(): Any? {
        val ctx = RequestContext.getCurrentContext()
        val request = ctx.request
        logger.info(String.format("%s >>> %s", request.method, request.requestURL.toString()))
        val accessToken = request.getParameter("token")
        if (accessToken == null) {
            logger.warn("token is empty")
            ctx.setSendZuulResponse(false)
            ctx.responseStatusCode = 401
            try {
                ctx.response.writer.write("token is empty")
            } catch (e: Exception) {
            }

            return null
        }
        logger.info("ok")
        return null
    }


    override fun shouldFilter(): Boolean {
        return true
    }

    override fun filterType(): String {
        return FilterConstants.PRE_TYPE
    }

    override fun filterOrder(): Int {
        return 0
    }

}