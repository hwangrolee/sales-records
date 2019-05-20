package com.hwangrolee.SalesRecords.config.resolver;

import com.hwangrolee.SalesRecords.exception.ExceptionType;
import com.hwangrolee.SalesRecords.exception.ParameterException;
import com.hwangrolee.SalesRecords.lib.DateType;
import com.hwangrolee.SalesRecords.lib.Regex;
import com.hwangrolee.SalesRecords.lib.SearchParameters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class SearchParameterResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return SearchParameters.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        SearchParameters searchParameters = new SearchParameters();

        Map<String, String[]> parameterMap = webRequest.getParameterMap();
        ParameterException parameterException = new ParameterException();

        if(parameterMap.containsKey("size")) {
            String p = parameterMap.get("size")[0];
            if(StringUtils.isEmpty(p) == false) {
                searchParameters.setSize(Integer.parseInt(p));
            }
        }

        if(parameterMap.containsKey("page")) {
            String p = parameterMap.get("page")[0];
            if(StringUtils.isEmpty(p) == false) {
                searchParameters.setPage(Integer.parseInt(p));
            }
        }

        if(parameterMap.containsKey("country")) {
            List<String> countries = Stream
                    .of(parameterMap.get("country")[0].split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
            searchParameters.setCountry(countries);
        }

        if(parameterMap.containsKey("region")) {
            List<String> regions = Stream
                    .of(parameterMap.get("region")[0].split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
            searchParameters.setRegion(regions);
        }

        if(parameterMap.containsKey("item_type")) {
            List<String> itemTypes = Stream
                    .of(parameterMap.get("item_type")[0].split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
            searchParameters.setItemType(itemTypes);
        }

        if(parameterMap.containsKey("order_priority")) {
            List<String> orderPriority = Stream
                    .of(parameterMap.get("order_priority")[0].split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());
            searchParameters.setOrderPriority(orderPriority);
        }

        if(parameterMap.containsKey("order_date")) {
            String orderDate = parameterMap.get("order_date")[0].trim();
            if(Regex.checkDate(orderDate)) {
                searchParameters.setOrderDate(orderDate);
            } else {
                String cause = parameterException.addParameter(orderDate, "order_date", DateType.DATE.getFormat(), ExceptionType.INVALID);
                log.error(cause);
            }
        }

        if(parameterMap.containsKey("ship_date")) {
            String shipDate = parameterMap.get("ship_date")[0].trim();
            if(Regex.checkDate(shipDate)) {
                searchParameters.setShipDate(shipDate);
            } else {
                String cause = parameterException.addParameter(shipDate, "ship_date", DateType.DATE.getFormat(), ExceptionType.INVALID);
                log.error(cause);
            }
        }

        if(parameterMap.containsKey("from_order_date")) {
            String fromOrderDate = parameterMap.get("from_order_date")[0].trim();
            if(Regex.checkDate(fromOrderDate)) {
                searchParameters.setFromOrderDate(fromOrderDate);
            } else {
                String cause = parameterException.addParameter(fromOrderDate, "from_order_date", DateType.DATE.getFormat(), ExceptionType.INVALID);
                log.error(cause);
            }
        }

        if(parameterMap.containsKey("from_order_time")) {
            String fromOrderTime = parameterMap.get("from_order_time")[0].trim();
            if(Regex.checkDate(fromOrderTime)) {
                searchParameters.setFromOrderTime(fromOrderTime);
            } else {
                String cause = parameterException.addParameter(fromOrderTime, "from_order_time", DateType.TIME.getFormat(), ExceptionType.INVALID);
                log.error(cause);
            }
        }

        if(parameterMap.containsKey("to_order_date")) {
            String toOrderDate = parameterMap.get("to_order_date")[0].trim();
            if(Regex.checkDate(toOrderDate)) {
                searchParameters.setToOrderDate(toOrderDate);
            } else {
                String cause = parameterException.addParameter(toOrderDate, "to_order_date", DateType.DATE.getFormat(), ExceptionType.INVALID);
                log.error(cause);
            }
        }

        if(parameterMap.containsKey("to_order_time")) {
            String toOrderTime = parameterMap.get("to_order_time")[0].trim();
            if(Regex.checkDate(toOrderTime)) {
                searchParameters.setToOrderTime(toOrderTime);
            } else {
                String cause = parameterException.addParameter(toOrderTime, "to_order_time", DateType.TIME.getFormat(), ExceptionType.INVALID);
                log.error(cause);
            }
        }


        if(parameterMap.containsKey("from_ship_date")) {
            String fromShipDate = parameterMap.get("from_ship_date")[0].trim();
            if(Regex.checkDate(fromShipDate)) {
                searchParameters.setFromShipDate(fromShipDate);
            } else {
                String cause = parameterException.addParameter(fromShipDate, "from_ship_date", DateType.DATE.getFormat(), ExceptionType.INVALID);
                log.error(cause);
            }
        }

        if(parameterMap.containsKey("from_ship_time")) {
            String fromShipTime = parameterMap.get("from_ship_time")[0].trim();
            if(Regex.checkDate(fromShipTime)) {
                searchParameters.setFromShipTime(fromShipTime);
            } else {
                String cause = parameterException.addParameter(fromShipTime, "from_ship_time", DateType.TIME.getFormat(), ExceptionType.INVALID);
                log.error(cause);
            }
        }

        if(parameterMap.containsKey("to_ship_date")) {
            String toShipDate = parameterMap.get("to_ship_date")[0].trim();
            if(Regex.checkDate(toShipDate)) {
                searchParameters.setToShipDate(toShipDate);
            } else {
                String cause = parameterException.addParameter(toShipDate, "to_ship_date", DateType.DATE.getFormat(), ExceptionType.INVALID);
                log.error(cause);
            }
        }

        if(parameterMap.containsKey("to_ship_time")) {
            String toShipTime = parameterMap.get("to_ship_time")[0].trim();
            if(Regex.checkDate(toShipTime)) {
                searchParameters.setToShipTime(toShipTime);
            } else {
                String cause = parameterException.addParameter(toShipTime, "to_ship_time", DateType.TIME.getFormat(), ExceptionType.INVALID);
                log.error(cause);
            }
        }

        if(parameterMap.containsKey("from_units_sold")) {
            String p = parameterMap.get("from_units_sold")[0].trim();
            if(StringUtils.isEmpty(p) == false) {
                try {
                    int fromUnitsSold = Integer.parseInt(p);
                    searchParameters.setFromUnitsSold(fromUnitsSold);
                } catch(NumberFormatException ex) {
                    String cause = parameterException.addParameter(p,"from_units_sold", "숫자(정수형)", ExceptionType.INVALID);
                    log.error(cause);
                }
            }
        }

        if(parameterMap.containsKey("to_units_sold")) {
            String p = parameterMap.get("to_units_sold")[0].trim();
            if(StringUtils.isEmpty(p) == false) {
                try {
                    int toUnitsSold = Integer.parseInt(p);
                    searchParameters.setToUnitsSold(toUnitsSold);
                } catch(NumberFormatException ex) {
                    String cause = parameterException.addParameter(p,"to_units_sold", "숫자(정수형)", ExceptionType.INVALID);
                    log.error(cause);
                }
            }
        }

        if(parameterMap.containsKey("from_unit_price")) {
            String p = parameterMap.get("from_unit_price")[0].trim();
            if(StringUtils.isEmpty(p) == false) {
                try {
                    float fromUnitPrice = Float.parseFloat(p);
                    searchParameters.setFromUnitPrice(fromUnitPrice);
                } catch(NumberFormatException ex) {
                    String cause = parameterException.addParameter(p,"from_unit_price", "숫자(실수형)", ExceptionType.INVALID);
                    log.error(cause);
                }
            }
        }

        if(parameterMap.containsKey("to_unit_price")) {
            String p = parameterMap.get("to_unit_price")[0].trim();
            if(StringUtils.isEmpty(p) == false) {
                try {
                    float toUnitPrice = Float.parseFloat(p);
                    searchParameters.setToUnitPrice(toUnitPrice);
                } catch(NumberFormatException ex) {
                    String cause = parameterException.addParameter(p,"to_unit_price", "숫자(실수형)", ExceptionType.INVALID);
                    log.error(cause);
                }
            }
        }

        if(parameterMap.containsKey("from_unit_code")) {
            String p = parameterMap.get("from_unit_code")[0].trim();
            if(StringUtils.isEmpty(p) == false) {
                try {
                    float fromUnitCode = Float.parseFloat(p);
                    searchParameters.setFromUnitCode(fromUnitCode);
                } catch(NumberFormatException ex) {
                    String cause = parameterException.addParameter(p,"from_unit_code", "숫자(실수형)", ExceptionType.INVALID);
                    log.error(cause);
                }
            }
        }

        if(parameterMap.containsKey("to_unit_code")) {
            String p = parameterMap.get("to_unit_code")[0].trim();
            if(StringUtils.isEmpty(p) == false) {
                try {
                    float toUnitCode = Float.parseFloat(p);
                    searchParameters.setToUnitCode(toUnitCode);
                } catch(NumberFormatException ex) {
                    String cause = parameterException.addParameter(p,"to_unit_code", "숫자(실수형)", ExceptionType.INVALID);
                    log.error(cause);
                }
            }
        }

        if(parameterMap.containsKey("from_total_revenue")) {
            String p = parameterMap.get("from_total_revenue")[0].trim();
            if(StringUtils.isEmpty(p) == false) {
                try {
                    float fromTotalRevenue = Float.parseFloat(p);
                    searchParameters.setFromTotalRevenue(fromTotalRevenue);
                } catch(NumberFormatException ex) {
                    String cause = parameterException.addParameter(p,"from_total_revenue", "숫자(실수형)", ExceptionType.INVALID);
                    log.error(cause);
                }
            }
        }

        if(parameterMap.containsKey("to_total_revenue")) {
            String p = parameterMap.get("to_total_revenue")[0].trim();
            if(StringUtils.isEmpty(p) == false) {
                try {
                    float toTotalRevenue = Float.parseFloat(p);
                    searchParameters.setToTotalRevenue(toTotalRevenue);
                } catch(NumberFormatException ex) {
                    String cause = parameterException.addParameter(p,"to_total_revenue", "숫자(실수형)", ExceptionType.INVALID);
                    log.error(cause);
                }
            }
        }

        if(parameterMap.containsKey("from_total_cost")) {
            String p = parameterMap.get("from_total_cost")[0].trim();
            if(StringUtils.isEmpty(p) == false) {
                try {
                    float fromTotalCost = Float.parseFloat(p);
                    searchParameters.setFromTotalCost(fromTotalCost);
                } catch(NumberFormatException ex) {
                    String cause = parameterException.addParameter(p,"from_total_cost", "숫자(실수형)", ExceptionType.INVALID);
                    log.error(cause);
                }
            }
        }

        if(parameterMap.containsKey("to_total_cost")) {
            String p = parameterMap.get("to_total_cost")[0].trim();
            if(StringUtils.isEmpty(p) == false) {
                try {
                    float toTotalCost = Float.parseFloat(p);
                    searchParameters.setToTotalCost(toTotalCost);
                } catch(NumberFormatException ex) {
                    parameterException.addParameter(p,"to_total_cost", "숫자(실수형)", ExceptionType.INVALID);
                    log.error(ex.getMessage());
                }
            }
        }

        if(parameterMap.containsKey("from_total_profit")) {
            String p = parameterMap.get("from_total_profit")[0].trim();
            if(StringUtils.isEmpty(p) == false) {
                try {
                    float fromTotalProfit = Float.parseFloat(p);
                    searchParameters.setFromTotalProfit(fromTotalProfit);
                } catch(NumberFormatException ex) {
                    String cause = parameterException.addParameter(p,"from_total_profit", "숫자(실수형)", ExceptionType.INVALID);
                    log.error(cause);
                }
            }
        }

        if(parameterMap.containsKey("to_total_profit")) {
            String p = parameterMap.get("to_total_profit")[0].trim();
            if(StringUtils.isEmpty(p) == false) {
                try {
                    float toTotalProfit = Float.parseFloat(p);
                    searchParameters.setToTotalProfit(toTotalProfit);
                } catch(NumberFormatException ex) {
                    String cause = parameterException.addParameter(p,"to_total_profit", "숫자(실수형)", ExceptionType.INVALID);
                    log.error(cause);
                }
            }
        }

        if(parameterException.isException()) {
            throw parameterException;
        }

        return searchParameters;
    }
}
