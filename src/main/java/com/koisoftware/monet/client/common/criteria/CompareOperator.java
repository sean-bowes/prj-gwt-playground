package com.koisoftware.monet.client.common.criteria;

import java.io.Serializable;

public enum CompareOperator implements Serializable {
    // Simple operators
    equals("="), notEqual("!="), lessThan("<"), greaterThan(">"), lessOrEqual("<="), greaterOrEqual(">="),

    // String operators
    iContains("like"), iStartsWith("like"), iEndsWith("like"), iNotContains("not like"), iNotStartsWith("not like"), iNotEndsWith(
            "not like"), iEquals("="), iNotEqual("!=")

    // Empty null checks
    , isEmpty("is null"), isNull("is null"), isNotEmpty("is not null"), isNotNull("is not null"), notNull("is not null")

    // Advanced Filter operators - Others
    , in("in"), allEq, between
    // Advanced Field Operators
    , equalsField("="), notEqualField("!=")
    //
    // String operators
    , contains("like"), begins("like"), ends("like")

    // // Simple operators --Deprecate same as equals("="), notEqual("!="),
    // lessThan("<"), greaterThan(">"), lessOrEqual("<="),
    // greaterOrEqual(">="),
    , eq("="), ne("!="), lt("<"), gt(">"), le("<="), ge(">=")

    // Advanced Field Operators-Deprecate same as equalsField("="),
    // notEqualField("!=")
    // , eqField("="), neField("!=")
    // // Boolean operators-Deprecate same as isNotNull("is not null")
    // , notNull("is not null")
    // , not("!") -- No such compare operator, present in Group operator.

    // End
    ;
    private final String symbol;

    private CompareOperator() {
        symbol = null;
    }

    private CompareOperator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
