package org.wangjin.vvserver.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.wangjin.vvserver.model.Hr;

public class HrUtils {
    public static Hr getCurrentHr() {
        return ((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
