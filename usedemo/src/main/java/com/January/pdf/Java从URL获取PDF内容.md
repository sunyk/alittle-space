# Java直接URL获取PDF内容

> 题外话
>
> 网上很多Java通过pdf转 HTML，转文本的，可是通过URL直接获取PDF内容，缺没有，浪费时间，本人最近工作中刚好用到，花了时间整理下，分享出来，防止浪费时间，Apache的pdfbox 2013年都有了。

~~~java
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;



import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


/**
 * 通过URL获得PDF内容 转存
 * @author sunyang
 * @date 2019/1/24 14:40
 */
public class PdfText2Url {

    public static void main(String[] args) {
        try {
            //需要获取到的PDF地址
    readPdf("https://img1.xxx.org/tech/file/9bd7/733b/7ef54fbf672cfffaf2b1a6c2.pdf");
        }catch (Exception e){

        }
    }

    /**
     * 传入一个.pdf 地址
     * @param pdfUrl 地址
     * @throws Exception
     */
    public static void readPdf(String pdfUrl) throws Exception {
        // 是否排序
        boolean sort = false;
        // 编码方式
        String encoding = "UTF-8";
        // 开始提取页数
        int startPage = 1;
        // 内存中存储的PDF Document
        PDDocument pdDocument = null;
        //输入流
        InputStream inputStream = null;
        try {
            try {
                // 当作一个URL来装载文件
                URL url = new URL(pdfUrl);
                URLConnection con = url.openConnection();
                con.setConnectTimeout(3 * 1000);
                inputStream = con.getInputStream();
                pdDocument = PDDocument.load(inputStream);
            } catch (MalformedURLException e) {

            }

            // 获取页码
            int endPage = pdDocument.getNumberOfPages();
            PDFTextStripper stripper = null;
            stripper = new PDFTextStripper();
            // 设置是否排序
            stripper.setSortByPosition(sort);
            // 设置起始页
            stripper.setStartPage(startPage);
            // 设置结束页
            stripper.setEndPage(endPage);
            System.out.println(stripper.getText(pdDocument));
            System.out.println(" 输出成功！");
        } finally {
            if (inputStream != null) {
                // 关闭输出流
                inputStream.close();
            }
            if (pdDocument != null) {
                // 关闭PDF Document
                pdDocument.close();
            }
        }
    }

}

~~~

`Pom.xml` 添加Apache的pdfbox，已经很成熟了

~~~xml
<dependency>
      <groupId>org.apache.pdfbox</groupId>
      <artifactId>fontbox</artifactId>
      <version>2.0.7</version>
    </dependency>

    <dependency>
      <groupId>org.apache.pdfbox</groupId>
      <artifactId>pdfbox</artifactId>
      <version>2.0.4</version>
    </dependency>
~~~





