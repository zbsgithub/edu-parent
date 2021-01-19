//package com.gzdata.core.controller.online;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.UUID;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.io.FilenameUtils;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import cn.hutool.log.StaticLog;
//
//import com.alibaba.fastjson.JSONObject;
//import com.gzdata.common.compoent.Constants;
//import com.gzdata.common.db.mybatis.result.Result;
//import com.gzdata.common.util.WebUtil;
//
///**
// * TODO
// *
// * @author zbs
// * @version 1.0
// * @date 2021/1/11 17:16
// */
//@RestController
//@RequestMapping("/api/anon")
//@CrossOrigin
//public class UeUploadController {
//
//    /**
//     * ueditor文件上传（上传到外部服务器）
//     * @param request
//     * @param response
//     * @param action
//     */
//    @RequestMapping
//    public void editorUpload(HttpServletRequest request, HttpServletResponse response, String action, MultipartFile upfile) {
//        response.setHeader("Content-Type" , "application/json");
//        response.setContentType("application/json;charset=UTF-8");
//        try {
//            if("config".equals(action)){    //如果是初始化
//                StaticLog.info("进入了初始化方法");
//                StaticLog.info(this.getBaseConfigInfo());
//                
//                PrintWriter writer = response.getWriter();
//                writer.write(this.getBaseConfigInfo());//写入基础配置信息
//                writer.flush();
//                writer.close();
//            }else if("uploadimage".equals(action) || "uploadfile".equals(action)){    //如果是上传图片、视频、和其他文件
//                try {
//
//                    JSONObject jo = new JSONObject();
//
//                    if(upfile!=null && upfile.getSize()!=0){//图片不为空
//
//                        long size = upfile.getSize();    //文件大小
//                        String originalFilename = upfile.getOriginalFilename();  //原来的文件名
//
//                        // 文件名称生成策略（日期时间+uuid ）
//                        UUID uuid = UUID.randomUUID();
//                        Date d = new Date();
//                        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
//                        String formatDate = format.format(d);
//                        // 获取文件的扩展名
////                        FileNameUtil.extName(file);
//                        String extension = FilenameUtils.getExtension(upfile.getOriginalFilename());
//                        // 文件名
//                        String fileName = formatDate + "-" + uuid + "." + extension;
//
//                        String a="";
//                        if("uploadimage".equals(action)){//判断是图片还是附件
//                            a = Constants.fileUploadPath + File.separator+"upload"+File.separator+"image"+File.separator;
//                        }else if("uploadfile".equals(action)){//附件
//                            a = Constants.fileUploadPath +File.separator+"upload"+File.separator+"file"+File.separator;
//                        }
////                         String a = fileUploadPath +"/upload/image/".substring(0, "/upload/image/".lastIndexOf("/"));
//                        File file2 = new File(a);
//                        if(!file2.exists()){
//                            boolean mkdirs = file2.mkdirs();
//                            System.out.println(mkdirs);
//                        }
//
//                        File newFile=null;
//                        if("uploadimage".equals(action)){//判断是图片还是附件
//                            newFile =new File(Constants.fileUploadPath +File.separator+"upload"+File.separator+"image"+File.separator+fileName);//文件具体路径
//                        }else if("uploadfile".equals(action)){//附件
//                            newFile=new File(Constants.fileUploadPath +File.separator+"upload"+File.separator+"file"+File.separator+fileName);//文件具体路径
//                        }
//
////             			File newFile=new File(fileUploadPath +"/upload/image/"+fileName);//文件具体路径
//                        try {
//                            upfile.transferTo(newFile);//保存图片或者附件
//
//                            jo.put("state", "SUCCESS");
//                            jo.put("original", originalFilename);//原来的文件名
//                            jo.put("size", size);//文件大小
//                            jo.put("title", originalFilename);//随意，代表的是鼠标经过图片时显示的文字
//                            jo.put("type", FilenameUtils.getExtension(upfile.getOriginalFilename()));//文件后缀名
//
//                            if("uploadimage".equals(action)){//判断是图片还是附件
//                                jo.put("url", File.separator+"image"+File.separator+"upload"+File.separator+"image"+File.separator+fileName);//这里的url字段表示的是上传后的图片在图片服务器的完整地址（http://ip:端口/*****/***.jpg）
//                            }else if("uploadfile".equals(action)){//附件
//                                jo.put("url", File.separator+"image"+File.separator+"upload"+File.separator+"file"+File.separator+fileName);//这里的url字段表示的是上传后的图片在图片服务器的完整地址（http://ip:端口/***//*****//***.jpg）
//                            }
//
//                        } catch (IllegalStateException e) {
//                            StaticLog.error("非法状态异常：",e);
//                            e.printStackTrace();
//                        } catch (IOException e) {
//                            StaticLog.error("IO异常：",e);
//                            e.printStackTrace();
//                        }
//
//                    }else{//图片为空
//                        jo.put("state", "ERROR");
//                        jo.put("original", "");//原来的文件名
//                        jo.put("size", 0);//文件大小
//                        jo.put("title", "");//随意，代表的是鼠标经过图片时显示的文字
//                        jo.put("type", "");//文件后缀名
//                        jo.put("url", "");//这里的url字段表示的是上传后的图片在图片服务器的完整地址（http://ip:端口/***//*****//***.jpg）
//                    }
//                    PrintWriter out = response.getWriter();
//                    out.write(jo.toString());
//                    out.close();//输出东西到
//
//                }catch (Exception e) {
//                    StaticLog.error("异常：",e);
//                }
//            }
//        } catch (Exception e) {
//            StaticLog.error("异常：",e);
//        }
//        
//    }
//
//   /**
//     *
//     * 功能描述：得到基础配置信息
//     *
//     * @return
//     *
//     * @author 张兵帅
//     *
//     * @since 2018年4月6日
//     *
//     * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
//     */
//    public String getBaseConfigInfo(){
//        JSONObject object=new JSONObject();
////       writer.write(exec);
////       writer.write("{'imageActionName': 'uploadimage'}");
//        object.put("videoMaxSize", 102400000);
//        object.put("videoActionName", "uploadvideo");
//        object.put("fileActionName", "uploadfile");
//        object.put("fileManagerListPath", "/ueditor/jsp/upload/file/");
//        object.put("imageCompressBorder", 1600);
//        String a[] =new String[]{".png",".jpg",".jpeg",".gif",".bmp"};
//        object.put("imageManagerAllowFiles",a );
//
//        object.put("imageManagerListPath", "/ueditor/jsp/upload/image/");
//        object.put("fileMaxSize", 51200000);
//        String b[]=new String[]{".png",".jpg",".jpeg",".gif",".bmp",".flv",".swf",".mkv",".avi",".rm",".rmvb",".mpeg",".mpg",".ogg",".ogv",".mov",".wmv",".mp4",".webm",".mp3",".wav",".mid",".rar",".zip",".tar",".gz",".7z",".bz2",".cab",".iso",".doc",".docx",".xls",".xlsx",".ppt",".pptx",".pdf",".txt",".md",".xml"};
//        object.put("fileManagerAllowFiles", b);
//
//        object.put("fileManagerActionName", "listfile");
//        object.put("snapscreenInsertAlign", "none");
//        object.put("scrawlActionName", "uploadscrawl");
//        object.put("videoFieldName", "upfile");
//        object.put("imageCompressEnable", true);
//        object.put("videoUrlPrefix", "");
//        object.put("fileManagerUrlPrefix", "");
//        object.put("catcherAllowFiles", new String []{".png",".jpg",".jpeg",".gif",".bmp"});
//        object.put("imageManagerActionName", "listimage");
//        object.put("snapscreenPathFormat", "/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}");
//
//        object.put("scrawlPathFormat","/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}" );
//        object.put("scrawlMaxSize", 2048000);
//        object.put("imageInsertAlign","none" );
//        object.put("catcherPathFormat","/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}" );
//
//
//        object.put("catcherMaxSize",2048000);
//        object.put("snapscreenUrlPrefix","");
////   	 object.put("imagePathFormat","/ueditor/jsp/upload/image/{yyyy}{mm}{dd}/{time}{rand:6}");
//        object.put("imagePathFormat","");
//        object.put("imageManagerUrlPrefix","");
//        object.put("scrawlUrlPrefix","");
//        object.put("scrawlFieldName","upfile");
//        object.put("imageMaxSize",2048000);
//        object.put("imageAllowFiles",new String[]{".png",".jpg",".jpeg",".gif",".bmp"});
//        object.put("snapscreenActionName","uploadimage");
//        object.put("catcherActionName","catchimage");
//        object.put("fileFieldName","upfile");
////   	 object.put("fileUrlPrefix","");//附件返回的前缀
//        object.put("fileUrlPrefix",WebUtil.getBasePath());
//        object.put("imageManagerInsertAlign","none");
//        object.put("catcherLocalDomain",new String []{"127.0.0.1","localhost","img.baidu.com"});
////   	 object.put("filePathFormat","/ueditor/jsp/upload/file/{yyyy}{mm}{dd}/{time}{rand:6}");
//        object.put("filePathFormat","");//附件格式临时置为空
//        object.put("videoPathFormat","/ueditor/jsp/upload/video/{yyyy}{mm}{dd}/{time}{rand:6}");
//        object.put("fileManagerListSize",20);
//        object.put("imageActionName","uploadimage");
//        object.put("imageFieldName","upfile");
////   	 object.put("imageUrlPrefix","");//图片路径前缀
//        object.put("imageUrlPrefix", WebUtil.getBasePath());//图片路径前缀
//        object.put("scrawlInsertAlign","none");
//        object.put("fileAllowFiles",new String[]{".png",".jpg",".jpeg",".gif",".bmp",".flv",".swf",".mkv",".avi",".rm",".rmvb",".mpeg",".mpg",".ogg",".ogv",".mov",".wmv",".mp4",".webm",".mp3",".wav",".mid",".rar",".zip",".tar",".gz",".7z",".bz2",".cab",".iso",".doc",".docx",".xls",".xlsx",".ppt",".pptx",".pdf",".txt",".md",".xml"});
//        object.put("catcherUrlPrefix","");
//        object.put("imageManagerListSize",20);
//        object.put("catcherFieldName","source");
//        object.put("videoAllowFiles",new String [] {".flv",".swf",".mkv",".avi",".rm",".rmvb",".mpeg",".mpg",".ogg",".ogv",".mov",".wmv",".mp4",".webm",".mp3",".wav",".mid"});
//
//        return object.toJSONString();
//    }
//    /**
//     *
//     * 功能描述：发文处上传图片
//     *
//     * @return
//     *
//     * @author 张兵帅
//     *
//     * @since 2018年4月9日
//     *
//     * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
//     */
//    @RequestMapping("/information/upload/img")
//    @ResponseBody
//    public Result submitInformationUploadImg(@RequestParam(name="file") MultipartFile file){
//
//        if(file!=null && file.getSize()!=0){//等于1是推荐展示：且存在文件
//
//            // 文件名称生成策略（日期时间+uuid ）
//            UUID uuid = UUID.randomUUID();
//            Date d = new Date();
//            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
//            String formatDate = format.format(d);
//            // 获取文件的扩展名
//            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
//            // 文件名
//            String fileName = formatDate + "-" + uuid + "." + extension;
//
//            String a= Constants.fileUploadPath +"upload"+File.separator+"banner"+File.separator;//创建路径及文件夹
//            File file2 = new File(a);
//            if(!file2.exists()){
//                boolean mkdirs = file2.mkdirs();
//                System.out.println(mkdirs);
//            }
//
//            File newFile=new File(Constants.fileUploadPath +"upload"+File.separator+"banner"+File.separator+fileName);//文件具体路径
//
//            try {
//                file.transferTo(newFile);//保存图片或者附件
//            }catch (Exception e){
//                e.printStackTrace();
//            }
////				dto.setLinkAddress();//文件路径
//            return Result.valueOf(Result.SUCCESS,"上传成功",WebUtil.getBasePath()+"image"+File.separator+"upload"+File.separator+"banner"+File.separator+fileName);
//
//        }
//
//        return Result.valueOf(Result.SUCCESS,"上传成功","");
//    }
//    /**
//     *
//     * 功能描述：发文处上传封面
//     *
//     * @param file
//     * @return
//     *
//     * @author 张兵帅
//     *
//     * @since 2018年4月18日
//     *
//     * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
//     */
//    @RequestMapping("/information/upload/cover/img")
//    @ResponseBody
//    public Result submitInformationUploadCoverImg(@RequestParam(name="file") MultipartFile file){
//
//        if(file!=null && file.getSize()!=0){//等于1是推荐展示：且存在文件
//
//            // 文件名称生成策略（日期时间+uuid ）
//            UUID uuid = UUID.randomUUID();
//            Date d = new Date();
//            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
//            String formatDate = format.format(d);
//            // 获取文件的扩展名
//            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
//            // 文件名
//            String fileName = formatDate + "-" + uuid + "." + extension;
//
//            String a= Constants.fileUploadPath +"upload"+File.separator+"cover"+File.separator;//创建路径及文件夹
//            File file2 = new File(a);
//            if(!file2.exists()){
//                boolean mkdirs = file2.mkdirs();
//                System.out.println(mkdirs);
//            }
//
//            File newFile=new File(Constants.fileUploadPath +"upload"+File.separator+"cover"+File.separator+fileName);//文件具体路径
//
//            try {
//                file.transferTo(newFile);//保存图片或者附件
//            }catch (Exception e){
//                e.printStackTrace();
//            }
////				dto.setLinkAddress();//文件路径
//            return Result.valueOf(Result.SUCCESS,"上传成功",WebUtil.getBasePath()+"image"+File.separator+"upload"+File.separator+"cover"+File.separator+fileName);
//
//        }
//
//        return Result.valueOf(Result.SUCCESS,"上传成功","");
//    }
//
//    /**
//     *
//     * 功能描述：上传底部banner
//     *
//     * @param file
//     * @return
//     *
//     * @author 张兵帅
//     *
//     * @since 2018年4月29日
//     *
//     * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
//     */
//    @RequestMapping("/upload/upload/buttom/banner/img")
//    @ResponseBody
//    public Result UploadButtomBannerImg(@RequestParam(name="file") MultipartFile file){
//        String fileOldNameString="";
//        if(file!=null && file.getSize()!=0){//等于1是推荐展示：且存在文件
//
//            // 文件名称生成策略（日期时间+uuid ）
//            UUID uuid = UUID.randomUUID();
//            Date d = new Date();
//            SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
//            String formatDate = format.format(d);
//
//            fileOldNameString=file.getOriginalFilename();//获取文件名称
//
//            // 获取文件的扩展名
//            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
//            // 文件名
//            String fileName = formatDate + "-" + uuid + "." + extension;
//
//            String a= Constants.fileUploadPath +"upload"+File.separator+"buttom_banner"+File.separator;//创建路径及文件夹
//            File file2 = new File(a);
//            if(!file2.exists()){
//                boolean mkdirs = file2.mkdirs();
//                System.out.println(mkdirs);
//            }
//
//            File newFile=new File(Constants.fileUploadPath +"upload"+File.separator+"buttom_banner"+File.separator+fileName);//文件具体路径
//
//            try {
//                file.transferTo(newFile);//保存图片或者附件
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
////            ButtomBanner buttomBanner = new ButtomBanner();
////            buttomBanner.setBannerName(fileOldNameString);//名称
////            buttomBanner.setBannerPath(WebUtil.getBasePath()+"image"+File.separator+"upload"+File.separator+"buttom_banner"+File.separator+fileName);//路径
////            buttomBannerService.insert(buttomBanner);
//
//            return Result.valueOf(Result.SUCCESS,"上传成功");
//
//        }
//
//        return Result.valueOf(Result.SUCCESS,"上传成功","");
//    }
//}
