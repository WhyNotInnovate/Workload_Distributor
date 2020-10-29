import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

class MyModel extends AbstractTableModel {

	String[] columnNames;
    // Just some dummy data
    Integer[][] data;

    // Init the dummy data
    public MyModel(int Days,int Time,int myarr[][],String[] tme) {
        super();
        
        columnNames=tme;
    	data = new Integer[Days][Time];

    	if(data ==null) {System.out.println("heh null");};
        for (int i = 0; i < data.length; i++) {
            Integer[] is = data[i];
            for (int j = 0; j < is.length; j++) {
                data[i][j] = myarr[i][j];
            }
        }
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return data[0].length;
    }

    @Override
    public Object getValueAt(int i, int j) {
        return data[i][j];
    }

    // Makes cells editable
    @Override
    public boolean isCellEditable(int i, int j) {
        return true;
    }

    @Override
    public void setValueAt(Object o, int i, int j) {
        if (o instanceof String) {
            char c = ((String) o).charAt(0);

            if (((String) o).length() == 1 && c >= '0' && c <= '1') {
                data[i][j] = Integer.valueOf(((String) o).substring(0, 1));
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Must input a number from 0-1");
    }

}