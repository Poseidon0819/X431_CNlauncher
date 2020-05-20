package com.cnlaunch.physics.bluetooth.remote;

interface IRemoteBluetoothManager {

	int getState();	

	String getCommand();		

	boolean getCommand_wait();

	void setCommand_wait(boolean wait);	

	String getDeviceName();

	void  closeDevice();	
	void autoConnectBluetooth(String serialNo, String deviceAddress);
	void connectBluetooth(String deviceAddress);
	boolean isAutoReConnect();
	boolean isAutoConnect();

	void setSerialNo(String serialNo);
	String getSerialNo();

	void setIsTruckReset(boolean isTruckReset);
	boolean isTruckReset();

	void userInteractionWhenDPUConnected();

	void setIsFix(boolean isFix);
	
	
	int inputStream_read0(); 
    int inputStream_read1(out byte[] buffer, int byteOffset, int byteCount);
   	int inputStream_available();
    void inputStream_close();
   
    void outputStream_write0(int oneByte);
    void outputStream_write1(in byte[] buffer, int offset, int count);   
    void outputStream_close();
    void outputStream_flush();

	void  physicalCloseDevice();

	String  getBluetoothDeviceAddress();


    void setIsRemoteClientDiagnoseMode(boolean isRemoteClientDiagnoseMode);
    boolean getIsRemoteClientDiagnoseMode();

    void setIsSupportOneRequestMoreAnswerDiagnoseMode(boolean isSupportOneRequestMoreAnswerDiagnoseMode);
    boolean getIsSupportOneRequestMoreAnswerDiagnoseMode();
}