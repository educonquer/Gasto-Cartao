package luan.melo.conquer.conquerprojectp2.file.storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FilePointer
{
	private String  name;
	
	private String  location;
	
	private String  description;
	
	private boolean bound;
}
