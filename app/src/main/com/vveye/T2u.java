package com.vveye;

public class T2u {
	
	/**
	 * 初始化
	 * @param svraddr	服务器地址或域名
	 * @param svrport	服务器端口
	 * @param svrkey	服务器密钥
	 */
	public native static void Init(String svraddr,char svrport,String svrkey);
	
	/**
	 * 添加映射端口
	 * 将远端设备的指定端口映射到本地
	 * @param uuid			设备UUID（如:设备序列号）	
	 * @param remote_port	对方的服务端口
	 * @param local_port	映射到本地的端口，0表示使用随机端口
	 * @return
	 * 		>0:  		映射到本地的端口
	 * 		-1:			创建端口失败，本地端口被占用
	 */
	public native static int AddPort(String uuid,char remote_port,char local_port);
	
	/**
	 * 添加映射端口
	 * 把远端设备当作代理，通过它把其他网络设备的端口映射到客户端本地
	 * @param uuid			设备UUID（如:设备序列号）	
	 * @param remote_ip		跟设备在同一局域网的其他设备的IP
	 * @param remote_port	对方的服务端口
	 * @param local_port	映射到本地的端口，0表示使用随机端口
	 * @return
	 * 		>0:  		映射到本地的端口
	 * 		-1:			创建端口失败，本地端口被占用
	 */
	public native static int AddPortEx(String uuid,String remote_ip,char remote_port,char local_port);
	
	/**
	 * 添加映射端口
	 * 
	 * @param uuid			设备UUID（如:设备序列号）	
	 * @param passwd		设备密码
	 * @param remote_ip		跟设备在同一局域网的其他设备的IP
	 * @param remote_port	对方的服务端口
	 * @param local_port	映射到本地的端口，0表示使用随机端口
	 * @return
	 * 		>0:  		映射到本地的端口
	 * 		-1:			创建端口失败，本地端口被占用
	 */
	public native static int AddPortV3(String uuid,String passwd,String remote_ip,char remote_port,char local_port);
	
	/**
	 * 关闭并删除已经映射的端口
	 * @param port		映射在本地的端口号
	 */
	public native static void DelPort(char port);
	
	/**
	 * 查询映射端口是否已经与远端设备连通
	 * @param port		映射在本地的端口号
	 * @return
	 * 		1:		已连通
	 *		0:		未连通
	 *		-1:		不存在
	 */
	public native static int PortStatus(char port);
	
	/**
	 * 查询与服务器连接状态
	 * @return
	 * 	1:		与服务器连接，状态正常
	 * 	0:		未连接服务器
	 * 	-1:		SDK未初始化
	 * 	-2:		服务器密钥无效
	 */
	public native static int Status();
	
	/**
	 * 查询设备在线状态
	 * @param uuid	设备UUID（如:设备序列号）	
	 * @return
	 * 	1:		设备在线
	 * 	0:		设备不在线
	 * 	-1:		查询失败
	 */
	public native static int Query(String uuid);
	
	/**
	 * 查询设备在线状态和附加参数
	 * @param uuid			设备UUID(如设备序列号)
	 * @param buff			保存设备附加参数的BYTE数组
	 * @param buffsize		保存设备附加参数的数组大小
	 * @param ipaddr		保存设备公网IP的BYTE数组
	 * @param ipsize		保存设备公网IP的数组大小
	 * @return
	 * 1:		设备在线
	 * 0:		设备不在线
	 * -1:		查询失败
	 */
	public native static int QueryEx(String uuid,byte buff[],int buffsize,byte ipaddr[],int ipsize);
	
	/**
	 * 搜索发现本地设备
	 * @param result	搜索结果,转为字符串，每行一条记录，格式为：uuid=xxxx,ip=x.x.x.x
	 * @return
	 * 	>=0		设备数
	 * 	-1:		搜索失败
	 */
	public native static int Search(byte result[]);
	
	/**
	 * 搜索对方内网的DVR设备
	 * @param uuid		设备UUID（如:设备序列号）	
	 * @param result	搜索结果,转为字符串，每行一条记录，格式为：厂家代码|DVR序列号|通道数|IP|端口
	 * @return
	 * 	1:		查询成功，有DVR 设备
	 * 	0:		查询成功，但无设备
	 * 	-1:		连接失败
	 * 	-2:		查询失败
	 * 	-3:		查询超时，对方无响应
	 */
	public native static int SearchDVR(String uuid,byte result[]);

	/**
	 * 退出并释放资源
	 */
	public native static void Exit();
	
	static {
		System.loadLibrary("t2u");
	}
}