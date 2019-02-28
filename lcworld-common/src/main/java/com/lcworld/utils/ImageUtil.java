package com.lcworld.utils;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;

public class ImageUtil {

	public static void main(String argv[]) {
		try {
			File fi = new File("c:/a.png"); // 大图文件
			File fo = new File("c:/b.jpg"); // 将要转换出的小图文件
			int nw = 100;
			/*
			 * AffineTransform 类表示 2D 仿射变换，它执行从 2D 坐标到其他 2D
			 * 坐标的线性映射，保留了线的“直线性”和“平行性”。可以使用一系 列平移、缩放、翻转、旋转和剪切来构造仿射变换。
			 */
			AffineTransform transform = new AffineTransform();
			BufferedImage bis = ImageIO.read(fi); // 读取图片
			int w = bis.getWidth();
			int h = bis.getHeight();
			// double scale = (double)w/h;
			int nh = (nw * h) / w;
			double sx = (double) nw / w;
			double sy = (double) nh / h;
			transform.setToScale(sx, sy); // setToScale(double sx, double sy)
											// 将此变换设置为缩放变换。
			// System.out.println(w + " " + h);
			/*
			 * AffineTransformOp类使用仿射转换来执行从源图像或 Raster 中 2D 坐标到目标图像或 Raster 中 2D
			 * 坐标的线性映射。所使用的插值类型由构造方法通过 一个 RenderingHints 对象或通过此类中定义的整数插值类型之一来指定。
			 * 如果在构造方法中指定了 RenderingHints 对象，则使用插值提示和呈现
			 * 的质量提示为此操作设置插值类型。要求进行颜色转换时，可以使用颜色 呈现提示和抖动提示。 注意，务必要满足以下约束：源图像与目标图像
			 * 必须不同。 对于 Raster 对象，源图像中的 band 数必须等于目标图像中 的 band 数。
			 */
			AffineTransformOp ato = new AffineTransformOp(transform, null);
			BufferedImage bid = new BufferedImage(nw, nh, BufferedImage.TYPE_3BYTE_BGR);
			/*
			 * TYPE_3BYTE_BGR 表示一个具有 8 位 RGB 颜色分量的图像， 对应于 Windows 风格的 BGR
			 * 颜色模型，具有用 3 字节存 储的 Blue、Green 和 Red 三种颜色。
			 */
			ato.filter(bis, bid);
			ImageIO.write(bid, "jpeg", fo);
			InputStream inputStream = new FileInputStream(fo);

			// System.out.println(available);
			inputStream.close();
			// fo.delete();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static InputStream getSmallImgStream(MultipartFile file) throws Exception {

		File fo = new File("a.jpg"); // 将要转换出的小图文件

		FileInputStream stream = null;
		try {
			// File fo = new File("c:/a.png"); // 大图文件
			InputStream in = file.getInputStream(); // 上传文件的输入流
			// int nw = 100;
			// /*
			// * AffineTransform 类表示 2D 仿射变换，它执行从 2D 坐标到其他 2D
			// * 坐标的线性映射，保留了线的“直线性”和“平行性”。可以使用一系 列平移、缩放、翻转、旋转和剪切来构造仿射变换。
			// */
			// AffineTransform transform = new AffineTransform();
			// BufferedImage bis = ImageIO.read(in); // 读取图片
			// int w = bis.getWidth();
			// int h = bis.getHeight();
			// // double scale = (double)w/h;
			// int nh = (nw * h) / w;
			// double sx = (double) nw / w;
			// double sy = (double) nh / h;
			// transform.setToScale(sx, sy); // setToScale(double sx, double sy)
			// // 将此变换设置为缩放变换。
			// System.out.println(w + " " + h);
			// /*
			// * AffineTransformOp类使用仿射转换来执行从源图像或 Raster 中 2D 坐标到目标图像或 Raster 中
			// 2D
			// * 坐标的线性映射。所使用的插值类型由构造方法通过 一个 RenderingHints
			// 对象或通过此类中定义的整数插值类型之一来指定。
			// * 如果在构造方法中指定了 RenderingHints 对象，则使用插值提示和呈现
			// * 的质量提示为此操作设置插值类型。要求进行颜色转换时，可以使用颜色 呈现提示和抖动提示。
			// 注意，务必要满足以下约束：源图像与目标图像
			// * 必须不同。 对于 Raster 对象，源图像中的 band 数必须等于目标图像中 的 band 数。
			// */
			// AffineTransformOp ato = new AffineTransformOp(transform, null);
			// BufferedImage bid = new BufferedImage(nw, nh,
			// BufferedImage.TYPE_3BYTE_BGR);
			// /*
			// * TYPE_3BYTE_BGR 表示一个具有 8 位 RGB 颜色分量的图像， 对应于 Windows 风格的 BGR
			// * 颜色模型，具有用 3 字节存 储的 Blue、Green 和 Red 三种颜色。
			// */

			BufferedImage image = Thumbnails.of(in).size(500, 500).asBufferedImage();
			

			ImageIO.write(image, "jpeg", fo);

			stream = FileUtils.openInputStream(fo);

			fo.delete();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return stream;

	}

	public static String getSmallUUID(String fileName) {
		String str = fileName.substring(fileName.lastIndexOf("."));

		String uuid = fileName.substring(0, fileName.lastIndexOf("."));

		return uuid + "_small" + str;
	}

}
