package com.cnlaunch.physics.remote;

import com.cnlaunch.physics.bluetooth.remote.IRemoteBluetoothManager;
import com.cnlaunch.physics.remote.IRemoteDeviceFactoryManagerCallBack;


interface IRemoteDeviceFactoryManager {

	IRemoteBluetoothManager getRemoteBluetoothManager(String serialNo,boolean isFix,in IRemoteDeviceFactoryManagerCallBack remoteDeviceFactoryManagerCallBack);

	void setDPUType(String serialNo,boolean isTruck,boolean isCarAndHeavyduty);

	int getDPULMSInternalReleaseVersionCode();

    List<BluetoothDevice> getConnectedBluetoothDeviceList();
}
