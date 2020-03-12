/**
 * Copyright 2014-2019  the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package webase.event.client.base.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import webase.event.client.base.code.ConstantCode;
import webase.event.client.base.exception.ParamException;
import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

public class BaseController {

    @Autowired
    protected HttpServletRequest request;

    /**
     * check param valid result.
     */
    protected void checkBindResult(BindingResult result) {
        if (result.hasErrors()) {
            String errFieldStr = result.getAllErrors().stream()
                .map(obj -> JSON.parseObject(JSON.toJSONString(obj)))
                .map(err -> err.getString("field"))
                .collect(Collectors.joining(","));
            StringUtils.removeEnd(errFieldStr, ",");
            String message = "these fields can not be empty:" + errFieldStr;
            throw new ParamException(ConstantCode.PARAM_EXCEPTION.getCode(), message);
        }
    }
}
