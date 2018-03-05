package com.siger.brewer.thymeleaf.processor;

import org.springframework.web.method.annotation.ModelFactory;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class MessageElementTagProcessor extends AbstractElementTagProcessor {
	
	private static final String NOME_TAG = "message";
	private static final int PRECEDENCIA = 1000;

	public MessageElementTagProcessor(String dialectPrefix) {
		super(TemplateMode.HTML, dialectPrefix, NOME_TAG, true, null, false, PRECEDENCIA);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doProcess(ITemplateContext context, IProcessableElementTag tag,
			IElementTagStructureHandler structureHandler) {
		
		IModelFactory modelFactory = context.getModelFactory();
		IModel model = modelFactory.createModel();
		
		model.add(modelFactory.createStandaloneElementTag("div","th:replace","layout/fragments/mensagemSucesso :: mensagemSucesso"));
		model.add(modelFactory.createStandaloneElementTag("div","th:replace","layout/fragments/mensagemErroValidacao :: mensagemErro"));
		
		structureHandler.replaceWith(model, true);
	}

}
