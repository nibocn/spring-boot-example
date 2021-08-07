package me.nibo.springboot.nacos.web;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.google.common.collect.Maps;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 读取 Nacos 配置示例 Controller
 *
 * @author NiBo
 */
@RestController
@RequestMapping("config")
public class ConfigController {

  @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
  private boolean useLocalCache;
  @NacosValue(value = "${myconfig.value1:}", autoRefreshed = true)
  private String value1;
  @NacosValue(value = "${myconfig.value2:}", autoRefreshed = true)
  private String value2;
  @NacosValue(value = "${myconfig.value3:}", autoRefreshed = true)
  private String value3;

  @GetMapping("details")
  public ResponseEntity<Map<String, Object>> get() {
    Map<String, Object> configMap = Maps.newHashMap();
    configMap.put("useLocalCache", useLocalCache);
    configMap.put("myconfig.value1", value1);
    configMap.put("myconfig.value2", value2);
    configMap.put("myconfig.value3", value3);
    return ResponseEntity.ok(configMap);
  }
}
