package pers.yuezejian.coldchainlogistics.common.exception.file;

import pers.yuezejian.coldchainlogistics.common.exception.BaseException;

/**
 * 文件信息异常类
 *
 * @Author: Yuezejian
 **/
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
