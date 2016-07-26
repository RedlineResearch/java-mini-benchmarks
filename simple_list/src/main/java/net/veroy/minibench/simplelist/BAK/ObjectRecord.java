package net.veroy.analysis.etracks;


public class ObjectRecord {
    private int _objId;
    private int _size;
    private int _length;
    private String _objtype;
    private int _atime;
    private int _dtime;
    private int _allocsite;

    public ObjectRecord( int objId,
                         String objtype,
                         int size,
                         int length,
                         int atime,
                         int dtime,
                         int allocsite
                         ) {
        super();
        this._objId = objId;
        this._size = size;
        this._length= length;
        this._atime = atime;
        this._dtime = dtime;
        this._allocsite = allocsite;
        this._objtype = objtype;
    }

    public ObjectRecord() {
        super();
        this._objId = 0;
        this._size = 0;
        this._length = 0;
        this._atime = 0;
        this._allocsite = 0;
        this._objtype = "None";
    }

    public int get_size() {
        return _size;
    }
    public void set_size(int _size) {
        this._size = _size;
    }
    public int get_length() {
        return _length;
    }
    public void set_length(int _length) {
        this._length = _length;
    }
    public int get_objId() {
        return _objId;
    }
    public void set_objId(int _objId) {
        this._objId = _objId;
    }
    public int get_atime() {
        return _atime;
    }
    public void set_atime(int _atime) {
        this._atime = _atime;
    }
    public int get_dtime() {
        return _dtime;
    }
    public void set_dtime(int _dtime) {
        this._dtime = _dtime;
    }
    public int get_allocsite() {
        return _allocsite;
    }
    public void set_allocsite(int _allocsite) {
        this._allocsite = _allocsite;
    }
    public String get_objtype() {
        return _objtype;
    }
    public void set_objtype(String _objtype) {
        this._objtype = _objtype;
    }


}
