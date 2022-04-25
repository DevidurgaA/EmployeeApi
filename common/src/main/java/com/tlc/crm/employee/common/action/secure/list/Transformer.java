package com.tlc.crm.employee.common.action.secure.list;

import java.util.Map;

public interface Transformer
{
    Object transform(Object data, Map<String, Object> allData);
}
