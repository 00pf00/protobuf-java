package cn.bupt.edu;

import cn.bupt.edu.entity.DeviceInfoProto;
import cn.bupt.edu.entity.pojo.DeviceInfo;
import cn.bupt.edu.util.Convert;
import com.google.protobuf.Message;

public class ProtoBuf {
    public static void main(String[] args) {
//       ProtocolReqMsgProto.ProtocolReqMsg.Builder builder =  ProtocolReqMsgProto.ProtocolReqMsg.newBuilder();
//       builder.setUuid(UUID.randomUUID().toString());
//       builder.setPath("/device/info");
//       builder.setVersion(1);
//       builder.setChain(0,"devicemanage");
//       byte[] body = new byte[]{};
//       body = "ProtocolReqMsg".getBytes();
//       builder.setBody(ByteString.copyFrom(body));
//       builder.build().toByteArray();
//
//       final byte[] finalBody = body;
//       new Runnable() {
//          @Override
//          public void run() {
//             try {
//               DeviceInfoProto.DeviceInfo device =  DeviceInfoProto.DeviceInfo.parseFrom(finalBody);
//             } catch (InvalidProtocolBufferException e) {
//                e.printStackTrace();
//             }
//          }
//       };
        DeviceInfoProto.DeviceInfo.Builder builder = DeviceInfoProto.DeviceInfo.newBuilder();
        builder.setId("1");
        builder.setName("a");
        builder.setTemperature(20);
        DeviceInfoProto.DeviceInfo deviceInfo = builder.build();
        DeviceInfo device = Convert.toPojo(builder.build(), DeviceInfo.class);
        System.out.println(device.getId());
        Message devicec = Convert.toProtobuf(device, DeviceInfoProto.DeviceInfo.newBuilder());
        if (devicec instanceof DeviceInfoProto.DeviceInfo) {
            DeviceInfoProto.DeviceInfo dd = (DeviceInfoProto.DeviceInfo) devicec;
            System.out.println(dd.getId());
        }


    }

}
