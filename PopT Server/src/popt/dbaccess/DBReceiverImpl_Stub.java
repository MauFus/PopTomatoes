// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package popt.dbaccess;

public final class DBReceiverImpl_Stub
    extends java.rmi.server.RemoteStub
    implements popt.rmi.DBReceiver, java.rmi.Remote
{
    private static final long serialVersionUID = 2;
    
    private static java.lang.reflect.Method $method_getStatus_0;
    private static java.lang.reflect.Method $method_insertMovie_1;
    private static java.lang.reflect.Method $method_insertShowtime_2;
    private static java.lang.reflect.Method $method_isAvailable_3;
    private static java.lang.reflect.Method $method_searchCinemaHalls_4;
    private static java.lang.reflect.Method $method_searchMovie_5;
    private static java.lang.reflect.Method $method_searchShowtime_6;
    
    static {
	try {
	    $method_getStatus_0 = popt.rmi.DBReceiver.class.getMethod("getStatus", new java.lang.Class[] {});
	    $method_insertMovie_1 = popt.rmi.DBReceiver.class.getMethod("insertMovie", new java.lang.Class[] {popt.data.Movie.class});
	    $method_insertShowtime_2 = popt.rmi.DBReceiver.class.getMethod("insertShowtime", new java.lang.Class[] {popt.data.Showtime.class});
	    $method_isAvailable_3 = popt.rmi.DBReceiver.class.getMethod("isAvailable", new java.lang.Class[] {});
	    $method_searchCinemaHalls_4 = popt.rmi.DBReceiver.class.getMethod("searchCinemaHalls", new java.lang.Class[] {});
	    $method_searchMovie_5 = popt.rmi.DBReceiver.class.getMethod("searchMovie", new java.lang.Class[] {popt.data.Movie.class});
	    $method_searchShowtime_6 = popt.rmi.DBReceiver.class.getMethod("searchShowtime", new java.lang.Class[] {popt.data.Showtime.class});
	} catch (java.lang.NoSuchMethodException e) {
	    throw new java.lang.NoSuchMethodError(
		"stub class initialization failed");
	}
    }
    
    // constructors
    public DBReceiverImpl_Stub(java.rmi.server.RemoteRef ref) {
	super(ref);
    }
    
    // methods from remote interfaces
    
    // implementation of getStatus()
    public java.lang.String getStatus()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_getStatus_0, null, 9222340217560959721L);
	    return ((java.lang.String) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of insertMovie(Movie)
    public boolean insertMovie(popt.data.Movie $param_Movie_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_insertMovie_1, new java.lang.Object[] {$param_Movie_1}, 6290647051933932907L);
	    return ((java.lang.Boolean) $result).booleanValue();
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of insertShowtime(Showtime)
    public boolean insertShowtime(popt.data.Showtime $param_Showtime_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_insertShowtime_2, new java.lang.Object[] {$param_Showtime_1}, 2581821848599957323L);
	    return ((java.lang.Boolean) $result).booleanValue();
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of isAvailable()
    public boolean isAvailable()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_isAvailable_3, null, -4336976199642666352L);
	    return ((java.lang.Boolean) $result).booleanValue();
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of searchCinemaHalls()
    public java.util.LinkedList searchCinemaHalls()
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_searchCinemaHalls_4, null, 795973579100426577L);
	    return ((java.util.LinkedList) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of searchMovie(Movie)
    public java.util.LinkedList searchMovie(popt.data.Movie $param_Movie_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_searchMovie_5, new java.lang.Object[] {$param_Movie_1}, -4265207580459390093L);
	    return ((java.util.LinkedList) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
    
    // implementation of searchShowtime(Showtime)
    public java.util.LinkedList searchShowtime(popt.data.Showtime $param_Showtime_1)
	throws java.rmi.RemoteException
    {
	try {
	    Object $result = ref.invoke(this, $method_searchShowtime_6, new java.lang.Object[] {$param_Showtime_1}, -4322657733655138081L);
	    return ((java.util.LinkedList) $result);
	} catch (java.lang.RuntimeException e) {
	    throw e;
	} catch (java.rmi.RemoteException e) {
	    throw e;
	} catch (java.lang.Exception e) {
	    throw new java.rmi.UnexpectedException("undeclared checked exception", e);
	}
    }
}
