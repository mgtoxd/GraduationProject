package pers.mtx.comments_provider.ab.service.impl;

import pers.mtx.comments_provider.ab.entity.CommentInfo;
import pers.mtx.comments_provider.ab.mapper.CommentInfoMapper;
import pers.mtx.comments_provider.ab.service.ICommentInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论基本信息表  服务实现类
 * </p>
 *
 * @author mataoxun
 * @since 2021-05-06
 */
@Service
public class CommentInfoServiceImpl extends ServiceImpl<CommentInfoMapper, CommentInfo> implements ICommentInfoService {

}
