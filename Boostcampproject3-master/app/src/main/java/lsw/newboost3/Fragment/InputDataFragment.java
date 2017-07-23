package lsw.newboost3.Fragment;



import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.text.Editable;
import android.widget.TextView;
import android.widget.Toast;

import lsw.newboost3.ItemResource.Item;
import lsw.newboost3.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class InputDataFragment extends Fragment {
    EditText resName;
    EditText resAddress;
    EditText resPhoneNum;
    EditText resContext;
    TextView countString;
    Button button;
    public InputDataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_data, container, false);


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
        resName = (EditText) getView().findViewById(R.id.resName);
        resAddress = (EditText) getView().findViewById(R.id.resAddress);
        resPhoneNum = (EditText) getView().findViewById(R.id.resPhoneNum);
        resContext = (EditText) getView().findViewById(R.id.resContext);
        countString = (TextView) getView().findViewById(R.id.countString);
        resContext.addTextChangedListener(new TextWatcher() {
            String str = "";
            String str1 = "";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                str = resContext.getText().toString();
                if(str.getBytes().length>80){
                    resContext.setText(str1);
                    resContext.setSelection(resContext.length());
                }
                else
                    countString.setText("글자수 : "+str.toString().length()+"/500");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        button = (Button) getView().findViewById(R.id.savaButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Item item = saveData();
                if(item.getResAddress().equals("") || item.getResName().equals("")){
                    Toast.makeText(getActivity(), "주소와 이름을 입력하세요", Toast.LENGTH_SHORT).show();
                }else{
                    mDatabaseListener.putData(item);
                    mListener.onOpenMap(item);

                }

            }
        });


    }

    public Item saveData(){

        Item item = new Item();

        item.setResName(resName.getText().toString());
        item.setResAddress(resAddress.getText().toString());
        item.setResPhoneNum(resPhoneNum.getText().toString());
        item.setResContext(resContext.getText().toString());

        return item;
    }

    public interface OnOpenMapListener {
       void onOpenMap(Item item);
    }
    public interface DatabaseListener{
        void putData(Item item);
    }

    OnOpenMapListener mListener;
    DatabaseListener mDatabaseListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
            try{
                mListener = (OnOpenMapListener) context;
        } catch (ClassCastException e) {
             throw new ClassCastException(context.toString() + " must implement OnOpenMapListener");
            }

            try{
                mDatabaseListener = (DatabaseListener) context;

            }catch(ClassCastException e){
                throw new ClassCastException(context.toString() + "must implement DatabaseListener");

            }

    }



}
