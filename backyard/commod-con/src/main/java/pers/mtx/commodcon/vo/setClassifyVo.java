package pers.mtx.commodcon.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author: 马韬循
 * @Description:
 * @DateTime: 2021/4/29 9:41
 **/
@Data
@Accessors(chain = true)
public class setClassifyVo {

    private List<String> classifyIds;

    private String commodId;

}
