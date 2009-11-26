//
// MessagePack for Java
//
// Copyright (C) 2009 FURUHASHI Sadayuki
//
//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at
//
//        http://www.apache.org/licenses/LICENSE-2.0
//
//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.
//
package org.msgpack.schema;

import java.io.IOException;
import org.msgpack.*;

public class IntSchema extends Schema {
	public IntSchema() {
		super("Integer");
	}

	@Override
	public String getExpression() {
		return "int";
	}

	@Override
	public void pack(Packer pk, Object obj) throws IOException {
		if(obj instanceof Number) {
			pk.packInt( ((Number)obj).intValue() );

		} else if(obj == null) {
			pk.packNil();

		} else {
			throw MessageTypeException.invalidConvert(obj, this);
		}
	}

	@Override
	public Object convert(Object obj) throws MessageTypeException {
		if(obj instanceof Integer) {
			return obj;

		} else if(obj instanceof Number) {
			return ((Number)obj).intValue();

		} else {
			throw MessageTypeException.invalidConvert(obj, this);
		}
	}

	@Override
	public Object createFromByte(byte v) {
		return (int)v;
	}

	@Override
	public Object createFromShort(short v) {
		return (int)v;
	}

	@Override
	public Object createFromInt(int v) {
		return (int)v;
	}

	@Override
	public Object createFromLong(long v) {
		return (int)v;
	}

	@Override
	public Object createFromFloat(float v) {
		return (int)v;
	}

	@Override
	public Object createFromDouble(double v) {
		return (int)v;
	}
}

