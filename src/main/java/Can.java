import java.util.BitSet;

public class Can {

    public static long getValue(long val, int startBit, int endBit) {
        BitSet source = BitSet.valueOf(new long[] { val });
        BitSet result = source.get(startBit, endBit);

        long[] lr = result.toLongArray();
        if ( lr.length == 0) {
            return 0;
        }
        return lr[0];
    }

    public static long setValue(long target, long val, int startBit, int endBit) {
        // Convert the target to a BitSet object in prep to manipulate
        BitSet result = BitSet.valueOf(new long[] { target });

        // Position the value between the start and end bits
        if ( startBit > 0 ) {
            val = (val << startBit);
        }

        // Convert it to a BitSet
        BitSet valueToSet = BitSet.valueOf(new long[] { val });

        // Clear the trailing bits to protect against overflow
        int len = valueToSet.length();
        if ( valueToSet.length() > endBit+1) {
            valueToSet.clear(endBit+1, valueToSet.length());
        }

        // Apply the bitmask via a bitwise OR operation
        result.or( valueToSet );

        long[] lr = result.toLongArray();
        if ( lr.length == 0) {
            return 0;
        }

        return lr[0];

    }

}

