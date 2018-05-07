package org.ufox.rubik.optimus.support.v;

import com.github.ooknight.rubik.core.session.Menu;
import com.github.ooknight.rubik.core.session.SessionUser;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Function;
import com.github.ooknight.rubik.optimus.archer.platform.entity.Module;
import com.github.ooknight.rubik.optimus.archer.platform.service.PlatformService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class APP {

    @Resource
    private PlatformService platformService;

    public List<Menu> menu() {
        List<Menu> result = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Set<String> resources = ((SessionUser) authentication.getPrincipal()).resources();
        for (Module module : platformService.menu()) {
            Menu temp = new Menu(module.getId() + "", module.getName());
            for (Function function : module.getFunction()) {
                if (resources.contains(function.getCode())) {
                    temp.getChildren().add(new Menu(function.getId() + "", function.getName(), function.getUrl(), function.getIcon()));
                }
            }
            if (!temp.getChildren().isEmpty()) {
                result.add(temp);
            }
        }
        return result;
    }

    public List<Menu> shortcut() {
        List<Menu> result = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Set<String> resources = ((SessionUser) authentication.getPrincipal()).resources();
        for (Function function : platformService.shortcut()) {
            if (resources.contains(function.getCode())) {
                result.add(new Menu(function.getId() + "", function.getName(), function.getUrl(), function.getIcon()));
            }
        }
        return result;
    }

    public String debug() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return JSON.toJSONString(authentication.getPrincipal(),
                SerializerFeature.WriteClassName,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.PrettyFormat);
    }
}
