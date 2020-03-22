package pers.yuezejian.coldchainlogistics.common.exception.user;

import pers.yuezejian.coldchainlogistics.common.exception.BaseException;

/**
 * 用户信息异常类
 *
 * @Author: Yuezejian
 **/
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
