package org.ufox.rubik.optimus.support.v;

import com.github.ooknight.rubik.core.session.Menu;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class APP {

    public List<Menu> menu() {
        List<Menu> result = new ArrayList<>();
        result.add(new Menu("demo:fun1", "测试功能1", "demo/fun1", null));
        result.add(new Menu("demo:fun2", "测试功能2", "demo/fun2", null));
        return result;
    }

    public List<Menu> shortcut() {
        return Lists.newArrayList();
    }

    public String debug() {
        return "ok";
    }
}
