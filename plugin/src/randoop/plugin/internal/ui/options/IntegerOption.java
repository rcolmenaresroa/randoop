package randoop.plugin.internal.ui.options;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.widgets.Text;

import randoop.plugin.internal.core.StatusFactory;

public abstract class IntegerOption extends TextOption {
  protected String fInvalidErrorMsg;
  
  public IntegerOption(Text text) {
    super(text);
  }
  
  protected void setInvalidIntErrorMessage(String invalidIntErrorMsg) {
    fInvalidErrorMsg = invalidIntErrorMsg;
  }
  
  @Override
  protected IStatus validate(String text) {
    try {
      Integer.parseInt(text);
      
      return StatusFactory.OK_STATUS;
    } catch (NumberFormatException nfe) {
      return StatusFactory.createErrorStatus(fInvalidErrorMsg);
    }
  }
}