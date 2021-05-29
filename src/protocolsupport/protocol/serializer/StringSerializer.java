package protocolsupport.protocol.serializer;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.utils.ProtocolVersionsHelper;
import protocolsupport.protocol.utils.SimpleTypeSerializer;

public class StringSerializer {

	private StringSerializer() {
	}

	public static final SimpleTypeSerializer<String> SERIALIZER = new SimpleTypeSerializer<>(
		new AbstractMap.SimpleEntry<>(StringSerializer::writeVarIntUTF8String, ProtocolVersionsHelper.UP_1_7),
		new AbstractMap.SimpleEntry<>(StringSerializer::writeShortUTF16BEString, ProtocolVersionsHelper.DOWN_1_6_4)
	);

	public static String readVarIntUTF8String(ByteBuf from) {
		return readString(from, VarNumberSerializer.readVarInt(from), StandardCharsets.UTF_8);
	}

	public static String readVarIntUTF8String(ByteBuf from, int limit) {
		int length = VarNumberSerializer.readVarInt(from);
		MiscSerializer.checkLimit(length, limit);
		return readString(from, length, StandardCharsets.UTF_8);
	}

	public static String readShortUTF16BEString(ByteBuf from, int limit) {
		int length = from.readUnsignedShort() * 2;
		MiscSerializer.checkLimit(length, limit * 2);
		return readString(from, length, StandardCharsets.UTF_16BE);
	}

	protected static String readString(ByteBuf from, int length, Charset charset) {
		String string = from.toString(from.readerIndex(), length, charset);
		from.skipBytes(length);
		return string;
	}

	public static void writeVarIntUTF8String(ByteBuf to, String string) {
		VarNumberSerializer.writeVarInt(to, ByteBufUtil.utf8Bytes(string));
		to.writeCharSequence(string, StandardCharsets.UTF_8);
	}

	public static void writeShortUTF16BEString(ByteBuf to, String string) {
		to.writeShort(string.length());
		to.writeCharSequence(string, StandardCharsets.UTF_16BE);
	}

	public static void writeString(ByteBuf to, ProtocolVersion version, String string) {
		SERIALIZER.get(version).accept(to, string);
	}

}
