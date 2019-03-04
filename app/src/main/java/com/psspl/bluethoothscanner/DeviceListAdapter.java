package com.psspl.bluethoothscanner;

import android.bluetooth.BluetoothDevice;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by haresh
 * on 25-09-2018.
 */

public class DeviceListAdapter extends RecyclerView.Adapter<DeviceListAdapter.MyViewHolder> {

    private List<BluetoothDevice> BluetoothDeviceList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtDeviceName, txtDeviceAddress, genre;

        public MyViewHolder(View view) {
            super(view);
            txtDeviceName = (TextView) view.findViewById(R.id.txtDeviceName);
            txtDeviceAddress = (TextView) view.findViewById(R.id.txtDeviceAddress);
        }
    }


    public DeviceListAdapter(List<BluetoothDevice> BluetoothDeviceList) {
        this.BluetoothDeviceList = BluetoothDeviceList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_location_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        BluetoothDevice mBluetoothDevice = BluetoothDeviceList.get(position);
        if (mBluetoothDevice.getName() != null && mBluetoothDevice.getName().length() > 0) {
            holder.txtDeviceName.setText(mBluetoothDevice.getName());
        }else{
            holder.txtDeviceName.setText(R.string.unknown_device);
        }
        holder.txtDeviceAddress.setText(mBluetoothDevice.getAddress());


    }

    @Override
    public int getItemCount() {
        return BluetoothDeviceList.size();
    }
}