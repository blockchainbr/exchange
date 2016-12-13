/*
 * This file is part of Bitsquare.
 *
 * Bitsquare is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bitsquare is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bitsquare. If not, see <http://www.gnu.org/licenses/>.
 */

package io.bitsquare.gui.main.dao.proposals;

import io.bitsquare.dao.proposals.ProposalPayload;
import io.bitsquare.gui.components.InputTextField;
import io.bitsquare.gui.util.Layout;
import javafx.scene.layout.GridPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

import static io.bitsquare.gui.util.FormBuilder.addLabelInputTextField;
import static io.bitsquare.gui.util.FormBuilder.addTitledGroupBg;

public class ProposalDisplay {
    private static final Logger log = LoggerFactory.getLogger(ProposalDisplay.class);

    private GridPane gridPane;
    public InputTextField nameTextField, titleTextField, categoryTextField, descriptionTextField, linkTextField,
            startDateTextField, endDateTextField, requestedBTCTextField, btcAddressTextField;
    private int gridRow = 0;

    public ProposalDisplay(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public void createAllFields(String title, double top) {
        addTitledGroupBg(gridPane, gridRow, 9, title, top);
        nameTextField = addLabelInputTextField(gridPane, gridRow, "Name/nickname:", top == Layout.GROUP_DISTANCE ? Layout.FIRST_ROW_AND_GROUP_DISTANCE : Layout.FIRST_ROW_DISTANCE).second;
        titleTextField = addLabelInputTextField(gridPane, ++gridRow, "Title:").second;
        categoryTextField = addLabelInputTextField(gridPane, ++gridRow, "Category:").second;
        descriptionTextField = addLabelInputTextField(gridPane, ++gridRow, "Description:").second;
        linkTextField = addLabelInputTextField(gridPane, ++gridRow, "Link to detail info:").second;
        startDateTextField = addLabelInputTextField(gridPane, ++gridRow, "Start date:").second;
        endDateTextField = addLabelInputTextField(gridPane, ++gridRow, "Delivery date:").second;
        requestedBTCTextField = addLabelInputTextField(gridPane, ++gridRow, "Requested funds in BTC:").second;
        btcAddressTextField = addLabelInputTextField(gridPane, ++gridRow, "Bitcoin address:").second;
    }

    public void fillWithProposalData(ProposalPayload proposal) {
        nameTextField.setText(proposal.name);
        titleTextField.setText(proposal.title);
        categoryTextField.setText(proposal.category);
        descriptionTextField.setText(proposal.description);
        linkTextField.setText(proposal.link);
        startDateTextField.setText(proposal.startDate.toString());
        endDateTextField.setText(proposal.endDate.toString());
        requestedBTCTextField.setText(proposal.requestedBtc.toPlainString());
        btcAddressTextField.setText(proposal.btcAddress.toString());
    }

    public void clearForm() {
        nameTextField.setText("");
        titleTextField.setText("");
        categoryTextField.setText("");
        descriptionTextField.setText("");
        linkTextField.setText("");
        startDateTextField.setText("");
        endDateTextField.setText("");
        requestedBTCTextField.setText("");
        btcAddressTextField.setText("");
    }

    public void fillWithMock() {
        int random = new Random().nextInt(100);
        nameTextField.setText("Mock name" + random);
        titleTextField.setText("Mock Title " + random);
        categoryTextField.setText("Mock Category " + random);
        descriptionTextField.setText("Mock Description " + random);
        linkTextField.setText("Mock Link " + random);
        startDateTextField.setText("Mock Start date " + random);
        endDateTextField.setText("Mock Delivery date " + random);
        requestedBTCTextField.setText("Mock Requested funds " + random);
        btcAddressTextField.setText("Mock Bitcoin address " + random);
    }

    public void setAllFieldsEditable(boolean isEditable) {
        nameTextField.setEditable(isEditable);
        titleTextField.setEditable(isEditable);
        categoryTextField.setEditable(isEditable);
        descriptionTextField.setEditable(isEditable);
        linkTextField.setEditable(isEditable);
        startDateTextField.setEditable(isEditable);
        endDateTextField.setEditable(isEditable);
        requestedBTCTextField.setEditable(isEditable);
        btcAddressTextField.setEditable(isEditable);
    }

    public void removeAllFields() {
        gridPane.getChildren().clear();
        gridRow = 0;
    }

    public int incrementAndGetGridRow() {
        return ++gridRow;
    }
}