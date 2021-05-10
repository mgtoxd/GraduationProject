package pers.mtx.commodpro.ab.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 行程详情
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("commod_trip_info")
public class CommodTripInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableField("commod_id")
    private String commodId;

    /**
     * 行程景点名称
     */
    @TableField("commod_trip_location")
    private String commodTripLocation;

    /**
     * 行程景点描述
     */
    @TableField("commod_trip_describe")
    private String commodTripDescribe;

    /**
     * 行程景点时间
     */
    @TableField("commod_trip_time")
    private String commodTripTime;

    /**
     * 行程景点排序
     */
    @TableField("commod_trip_sort")
    private String commodTripSort;

    /**
     * 创建时间
     */
    @TableField(value = "create_date", fill = FieldFill.INSERT)
    private LocalDateTime createDate;

    /**
     * 更新时间
     */
    @TableField(value = "modify_date", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime modifyDate;

    /**
     * 逻辑删除
     */
    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDeleted;


}
