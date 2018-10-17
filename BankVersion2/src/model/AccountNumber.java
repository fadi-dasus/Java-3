package model;

import java.io.Serializable;

public final class AccountNumber implements Serializable
{
   private static final long serialVersionUID = 1L;

   private int regNumber;
   private long accountNumber;

   public AccountNumber(int regNumber, long accountNumber)
   {
      this.regNumber = regNumber;
      this.accountNumber = accountNumber;
   }

   public int getRegNumber()
   {
      return regNumber;
   }

   public long getAccountNumber()
   {
      return accountNumber;
   }

   @Override
   public int hashCode()
   {
      return Integer.hashCode(regNumber) ^ Long.hashCode(accountNumber);
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof AccountNumber))
      {
         return false;
      }
      AccountNumber other = (AccountNumber) obj;
      return this.regNumber == other.regNumber
            && this.accountNumber == other.accountNumber;

   }

   public String toString()
   {
      return String.format("%s %010d", regNumber, accountNumber);
   }
}