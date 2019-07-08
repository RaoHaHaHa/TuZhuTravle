package com.qf.travel.service.Impl;

import com.qf.travel.common.GetIpUtils;
import com.qf.travel.common.MD5;
import com.qf.travel.common.SeedEmail;
import com.qf.travel.common.SeedMessage;
import com.qf.travel.controller.vo.ResponseCode;
import com.qf.travel.controller.vo.ServerResponse;
import com.qf.travel.entity.User;
import com.qf.travel.mapper.UserMapper;
import com.qf.travel.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Description: 用户service层的实现类
 * @Author: Qian
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userDao;
    User user  = new User();

    /**
     * 注册获取邮箱验证码
     * @param request
     * @param registEmail
     * @return
     */
    @Override
    public ServerResponse getEmailCode(HttpServletRequest request, String registEmail) {
        //验证邮箱是否存在
        User user = this.selectUserByEmail(registEmail).getData();
        if (user != null) {
            return ServerResponse.createByException("您的邮箱已经注册过,请直接登陆");
        }
        //拿到当前用户的session
        HttpSession session = request.getSession();
        //验证上次请求验证码时间
        Date date = (Date) session.getAttribute("emailLastTime");
        if (date != null) {
            //判断是否在分钟之内请求
            Long time = (System.currentTimeMillis() - date.getTime()) / 1000;
            if (time < 300) {
                //回应错误码和剩余的秒数
                return ServerResponse.createByException(ResponseCode.REQUEST_ERROR.getCode(), String.valueOf(300 - time));
            }
        }
        //验证邮箱是否合法
        if (registEmail != null && registEmail.indexOf("@") > 0 & registEmail.length() < 20) {
            //生成随机码
            int code = (int) ((Math.random() * 9 + 1) * 10000);
            System.out.println("准备发送邮件:" +registEmail);
            String title = "欢迎注册途猪网";
            String body = "【途猪旅游网】您的验证码是: " + String.valueOf(code) + " \t\t\t 5分钟内有效！打死也不要告诉别人哦,如非本人操作请忽略";
            String sign = SeedEmail.seedEmail(registEmail,body,title);
            if (sign=="0") {
                session.setAttribute("registEmail", registEmail);
                session.setAttribute("emailCode", String.valueOf(code));
                session.setAttribute("emailLastTime", new Date());
                return new ServerResponse(true, 200,"","验证码发送成功");
            } else {
                return ServerResponse.createByException(ResponseCode.REQUEST_ERROR.getCode(), "邮箱地址有误,发送失败");
            }
        } else {
            return ServerResponse.createByException(ResponseCode.REQUEST_ERROR.getCode(), "邮箱地址有误,发送失败");
        }
    }

    /**
     * 验证邮箱验证码
     * @param request
     * @param registEmail
     * @param code
     * @return
     */
    @Override
    public ServerResponse verifyEmailCode(HttpServletRequest request, String registEmail, String code) {
        //拿到当前用户的session
        HttpSession session = request.getSession();
        //取出验证码
        String emailCode = (String) session.getAttribute("emailCode");
        //取出当前验证邮箱
        String email2 = (String) session.getAttribute("registEmail");

        //验证邮箱
        if (email2 != null && registEmail.equals(email2)) {
            //判断验证码是否合法
            if (emailCode != null && emailCode.equalsIgnoreCase(code)) {
                return new ServerResponse(true, 200,"","验证码验证通过");
            }
        }
        return ServerResponse.createByException(ResponseCode.REQUEST_ERROR.getCode(), "邮箱验证失败,请检查邮箱地址或验证码输入是否正确");
    }

    /**
     * 通过邮箱注册
     * @param registEmail
     * @param password
     * @return
     */
    @Override
    public ServerResponse registerByEmail(String username, String registEmail, String password) {
        System.out.println("---------------");
        System.out.println("email = " + registEmail);
        System.out.println("usernaem = " + username);
        System.out.println("password = " + password);
        //验证邮箱和密码是否合法
        if ((username == null || "".equals(username))||(registEmail == null || "".equals(registEmail)) || (password == null || "".equals(password))) {
            return ServerResponse.createByException(ResponseCode.REQUEST_ERROR.getCode(), "用户名,邮箱或者密码输入不正确");
        }
        User data1 = this.selectUserByUserName(username).getData();
        if (data1 != null) {
            return ServerResponse.createByException("用户名已经存在");
        }
        User data2 = this.selectUserByEmail(registEmail).getData();
        if (data2 != null) {
            return ServerResponse.createByException("邮箱已经存在");
        }
        User user = new User();
        user.setRegistEmail(registEmail);
        user.setUsername(username);
        user.setRegistTime(new Timestamp(new Date().getTime()));
        user.setRegistStatus("1");
        user.setUserState("1");
        user.setPassword(MD5.getMD5(password));
        try{
            Integer integer = userDao.insertUser(user);
            if(integer>0){
                return new ServerResponse(true, 200,"","注册成功啦");
            }
            return ServerResponse.createBySuccess(ResponseCode.ERROR.getCode(), "服务器繁忙,请稍后重试");
        }catch (Exception e){
            e.printStackTrace();
            return ServerResponse.createBySuccess(ResponseCode.ERROR.getCode(), "服务器繁忙,请稍后重试");
        }
    }

    /**
     * 获取手机验证码
     * @param request
     * @param registPhone
     * @return
     */
    @Override
    public ServerResponse getPhoneCode(HttpServletRequest request, String registPhone) {
        //验证手机号是否存在
        user = this.selectUserByPhone(registPhone).getData();
        if (user != null) {
            return ServerResponse.createByException("您的手机已经注册过,请直接登陆");
        }
        //拿到当前用户的session
        HttpSession session = request.getSession();
        //验证上次请求验证码时间
        Date date = (Date) session.getAttribute("phoneLastTime");
        if (date != null) {
            //判断是否在分钟之内请求
            Long time = (System.currentTimeMillis() - date.getTime()) / 1000;
            if (time < 300) {
                //回应错误码和剩余的秒数
                return ServerResponse.createByException(ResponseCode.REQUEST_ERROR.getCode(), String.valueOf(300 - time));
            }
        }
        //验证手机是否合法
        if (registPhone != null && registPhone.length() == 11) {
            //生成随机码
            int code = (int) ((Math.random() * 9 + 1) * 1000);
            System.out.println("准备发送手机验证码:" +registPhone);
            String body = "【途猪旅游网】您的验证码是:"+code+",５分钟内有效。若非本人操作请忽略此消息。";
            String sign = SeedMessage.seedMessage(registPhone,body);
            if (sign=="0") {
                session.setAttribute("registPhone", registPhone);
                session.setAttribute("phoneCode", String.valueOf(code));
                session.setAttribute("phoneLastTime", new Date());
                return ServerResponse.createBySuccess(true);
            } else {
                return ServerResponse.createByException(ResponseCode.REQUEST_ERROR.getCode(), "手机号有误,发送失败");
            }
        } else {
            return ServerResponse.createByException(ResponseCode.REQUEST_ERROR.getCode(), "手机号有误,发送失败");
        }
    }

    /**
     * 短信码验证
     * @param request
     * @param registPhone
     * @param code
     * @return
     */
    @Override
    public ServerResponse verifyPhoneCode(HttpServletRequest request, String registPhone, String code) {
        //拿到当前用户的session
        HttpSession session = request.getSession();
        //取出验证码
        String phoneCode = (String) session.getAttribute("phoneCode");
        //取出当前验证手机
        String phone2 = (String) session.getAttribute("registPhone");

        //验证手机
        if (phone2 != null && phone2.equals(registPhone)) {
            //判断验证码是否合法
            if (phoneCode != null && phoneCode.equalsIgnoreCase(code)) {
                return new ServerResponse(true, 200,"","验证通过");
            }
        }
        return ServerResponse.createByException(ResponseCode.REQUEST_ERROR.getCode(), "手机验证失败,请检查手机号或验证码是否正确");
    }

    /**
     * 通过手机号注册
     * @param username
     * @param registPhone
     * @param password
     * @return
     */
    @Override
    public ServerResponse registerByPhone(String username, String registPhone, String password) {
        //验证用户名,手机和密码是否合法
        if ((username == null || "".equals(username))||(registPhone == null || "".equals(registPhone)) || (password == null || "".equals(password))) {
            return ServerResponse.createByException(ResponseCode.REQUEST_ERROR.getCode(), "用户名,手机或者密码输入不正确");
        }
        User data1 = this.selectUserByUserName(username).getData();
        if (data1 != null) {
            return ServerResponse.createByException("用户名已经存在");
        }
        User data2 = this.selectUserByPhone(registPhone).getData();
        if (data2 != null) {
            return ServerResponse.createByException("手机号已经注册过啦");
        }
        User user = new User();
        user.setRegistPhone(registPhone);
        user.setUsername(username);
        user.setRegistTime(new Timestamp(new Date().getTime()));
        user.setRegistStatus("1");
        user.setUserState("1");
        user.setPassword(MD5.getMD5(password));
        try{
            userDao.insertUser(user);
            return new ServerResponse(true, 200,"","注册成功");
        }catch (Exception e){
            e.printStackTrace();
            return ServerResponse.createBySuccess(ResponseCode.ERROR.getCode(), "服务器繁忙,请稍后重试");
        }
    }

    /**
     * @Description: 用户登陆
     * @Author: Qian
     * @param session
     * @param account
     * @param password
     * @return
     */
    @Override
    public ServerResponse userLogin(HttpServletRequest request, HttpSession session, String account, String password) {
        User loginUser = null;
        //先根据手机号查询
        if ((loginUser = selectUserByPhone(account).getData()) == null) {
            //再根据邮箱进行查询
            if ((loginUser = selectUserByEmail(account).getData()) == null) {
                //再根据用户名进行查询
                if ((loginUser = selectUserByUserName(account).getData()) == null) {
                    return ServerResponse.createByException(ResponseCode.NOT_FOUND.getCode(), "用户不存在");
                }
            }
        }
        //使用MD5加密验证用户的密码
        if (loginUser.getPassword().equals(MD5.getMD5(password))) {
            session.setAttribute("user", loginUser);
            String ip = GetIpUtils.getIpAddr(request);
            userDao.autoUpdateUser(new User(loginUser.getId(),new Timestamp(System.currentTimeMillis()),ip));
            return new ServerResponse(true, 200,"",loginUser);
        }
        return ServerResponse.createByException(ResponseCode.NOT_FOUND.getCode(), "密码有误");
    }

    /**
     * 插入用户
     * @param user
     * @return
     */
    @Override
    public ServerResponse insertUser(User user) {
        if(userDao.insertUser(user)>0){
            return new ServerResponse(true, 200,"","插入成功");
        }
        return ServerResponse.createBySuccess(ResponseCode.ERROR.getCode(), "服务器繁忙,请稍后重试");
    }

    /**
     * 删除或者注销用户
     * @param id 要注销的用户id
     * @return
     */
    @Override
    public ServerResponse logoutUser(Long id) {
        if(userDao.logoutUser(id)>0){
            return new ServerResponse(true, 200,"","注销成功");
        }
        return ServerResponse.createBySuccess(ResponseCode.ERROR.getCode(), "服务器繁忙,请稍后重试");
    }

    /**
     * 用户修改数据
     * @param user
     * @return
     */
    @Override
    public ServerResponse updateUser(User user) {
        if(userDao.updateUser(user)>0){
            return new ServerResponse(true, 200,"","数据刷新成功");
        }
        return ServerResponse.createBySuccess(ResponseCode.ERROR.getCode(), "服务器繁忙,请稍后重试");
    }

    /**
     * 更新用户登陆信息
     * @param user
     * @return
     */
    @Override
    public ServerResponse autoUpdateUser(User user) {
        if(userDao.autoUpdateUser(user)>0){
            return new ServerResponse(true, 200,"","数据刷新成功");
        }
        return ServerResponse.createBySuccess(ResponseCode.ERROR.getCode(), "服务器繁忙,请稍后重试");
    }

    /**
     * 通过id查询用户
     * @param id 要查询的id
     * @return
     */
    @Override
    public ServerResponse<User> selectUserById(Long id) {
        user = userDao.selectUserById(id);
        if (user!=null){
            return new ServerResponse(true, 200,"",user);
        }
        return ServerResponse.createBySuccess(ResponseCode.NOT_FOUND.getCode(), null);
    }
    /**
     * 邮箱查询用户
     * @param registEmail
     * @return
     */
    @Override
    public ServerResponse<User> selectUserByEmail(String registEmail) {
        user = userDao.selectUserByEmail(registEmail);
        if (user!=null){
            return new ServerResponse(true, 200,"",user);
        }
        return ServerResponse.createBySuccess(ResponseCode.NOT_FOUND.getCode(),null);
    }

    /**
     * 手机查询用户
     * @param registPhone
     * @return
     */
    @Override
    public ServerResponse<User> selectUserByPhone(String registPhone) {
        user = userDao.selectUserByPhone(registPhone);
        if (user!=null){
            return new ServerResponse(true, 200,"",user);
        }
        return ServerResponse.createBySuccess(ResponseCode.NOT_FOUND.getCode(),null);
    }
    /**
     * 用户名查询用户
     * @param username
     * @return
     */
    @Override
    public ServerResponse<User> selectUserByUserName(String username) {
        user = userDao.selectUserByUsername(username);
        if (user!=null){
            return new ServerResponse(true, 200,"",user);
        }
        return ServerResponse.createBySuccess(ResponseCode.NOT_FOUND.getCode(), user);
    }

    /**
     * 用户退出
     * @param request
     * @return
     */
    @Override
    public ServerResponse outUser(HttpServletRequest request, HttpServletResponse response) {
        //1.销毁session
        request.getSession().invalidate();
        //2.删除Cookie
        Cookie userCookie = new Cookie("username","name");
        //设置生存期为0删除Cookie
        userCookie.setMaxAge(0);
        response.addCookie(userCookie);
        return new ServerResponse(true, 200,"","退出成功");
    }

    /**
     * 获取登陆用户
     * @param request
     * @param response
     * @return
     */
    @Override
    public ServerResponse findOne(HttpServletRequest request, HttpServletResponse response) {
        User user = (User)request.getSession().getAttribute("user");
        return new ServerResponse(true, 200,"",user);
    }

//    /**
//     * @Description: 根据用户的查询条件查询
//     * @Author: Qian
//     **/
//    private ServerResponse<User> findByUserVi(User loginUser) {
//       user = userDao.
//       if (user.getId()!=null||user!=null){
//           return ServerResponse.createBySuccess(ResponseCode.SUCCESS.getCode(), user);
//       }
//       return ServerResponse.createBySuccess(ResponseCode.NOT_FOUND.getCode(), null);
//    }
//    private Timestamp getNowTime(){
//        Timestamp loginTime = new Timestamp(System.currentTimeMillis());
//        return loginTime;
//    }
}
